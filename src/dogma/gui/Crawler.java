package dogma.gui;

import java.awt.Color;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

public class Crawler {

    private int maxDepth;
    private int maxDequeSize;
    private int current_depth;
    private boolean grabImages;
    private boolean prio2New;
    private boolean stayInDomain;
    private int minImageSize2Grab;
    private Deque<String> links;
    private final Deque<String> linksnew;
    private final Deque<UrlToCrawl> urlsToCrawl;
    private final Deque<String> domainsCrawled;
    private boolean write2DB;
    private int jumped;

    public Crawler() {
        links = new LinkedList();
        linksnew = new LinkedList();
        urlsToCrawl = new LinkedList();
        domainsCrawled = new LinkedList();
        jumped = 0;
        }

    public void initCrawler(String URL) throws Exception {
        current_depth = 0;
        String urlstripped = URL.replaceAll("[?].*", "");
        UrlToCrawl urlToCrawl = new UrlToCrawl(urlstripped, current_depth, false);
        /*Read crawled links from DB
        ConnectionDB.OpenConnection();
        links = ConnectionDB.dbGetCrawledUrls();
        System.out.println("Read " + links.size() + " previously crawled URL's from the database.");
        ConnectionDB.CloseConnection();*/
        urlsToCrawl.add(urlToCrawl);
        //Go to the Crawling part of the Crawling
        continueCrawling();
    }

    public void continueCrawling() throws Exception {

        while (!urlsToCrawl.isEmpty()) {
            maxDepth = Integer.parseInt(DogmaMainWindow.jTextMaxDepth.getText());
            maxDequeSize = Integer.parseInt(DogmaMainWindow.jTextMaxDequeSize.getText());
            minImageSize2Grab = Integer.parseInt(DogmaMainWindow.jTextMinImgSizeKB.getText());
            prio2New = DogmaMainWindow.jRadioPrio2New.isSelected();
            stayInDomain = DogmaMainWindow.jRadioStayInDomain.isSelected();
            UrlToCrawl utc = urlsToCrawl.getFirst();
            urlsToCrawl.removeFirst();
            String url1 = utc.getUrlToCrawl();
            String url1Domain = CommonBal.getDomainName(url1);
            DogmaMainWindow.currenlyCrawlingUrl.setText(url1);
            if (!linksnew.contains(url1) && !links.contains(url1)) {
                linksnew.add(url1);
            }
            current_depth = utc.getDepth();
            System.out.print(urlsToCrawl.size() + " D:" + utc.getDepth() + " - [" + url1 + "] ");

            //Grabbing images from the crawled webpages
            grabImages = DogmaMainWindow.jRadioGrabImg.isSelected();
            if (grabImages) {
                if (minImageSize2Grab > 1) {
                    new ImageScraper().getImages(url1, minImageSize2Grab*1028);
                } else {
                    System.out.println("Minimum Image Size is set too small");
                }
            } else {
                System.out.print("   NOT scraping images!\n");
            }

            try {
                //System.out.println("Crawler Try grabbing site");
                boolean isimage = false;
                Document document = Jsoup.connect(url1).get();
                Elements linksOnPage = document.select("a[href]");
                current_depth++;
                if (current_depth <= maxDepth) {
                    //System.out.println("current depth <= max depth");
                    for (Element page : linksOnPage) {
                        String hhref = page.attr("abs:href");
                        if (CommonBal.urlValidator(hhref)) {
                            String hhref2 = CommonBal.urlCleanup(hhref);
                            String hhref2Domain = CommonBal.getDomainName(hhref2);
                            //System.out.println("hhref:" + hhref2);

                            int extensionstart = hhref2.lastIndexOf(".");
                            extensionstart++;
                            String extension = hhref2.substring(extensionstart);
                            //System.out.println("Extention = " + extension);

                            if (extension.matches("jpg|JPG|gif|GIF|png|PNG|rss|pdf|PDF")) {
                                isimage = true;
                            }

                            if (!isimage && !links.contains(hhref2) && !linksnew.contains(hhref2)) {
                                UrlToCrawl newurl;
                                newurl = new UrlToCrawl(hhref2, current_depth, false);
                                if (hhref2.length() > 5 && !(stayInDomain && !(url1Domain.equals(hhref2Domain)))) {                               
                                    if (!domainsCrawled.contains(url1Domain)) {
                                        domainsCrawled.add(url1Domain);
                                    }                                                                        
                                    if (prio2New && !domainsCrawled.contains(hhref2Domain)) {
                                        System.out.println("DUMPING DEQUE TO START OVER FROM NEW DOMAIN");
                                        int stripdeque = urlsToCrawl.size()-4;
                                        for (int i=1; i<stripdeque; i++) {
                                            urlsToCrawl.removeLast();
                                        }
                                        urlsToCrawl.addFirst(newurl);
                                        linksnew.add(newurl.getUrlToCrawl());
                                        jumped = 5;
                                        break;
                                    } else if (urlsToCrawl.size() < maxDequeSize) {
                                        //System.out.println("Add link to urls to crawl list");
                                        urlsToCrawl.add(newurl);
                                        if (jumped>0) {
                                            urlsToCrawl.removeFirst();
                                            jumped--;
                                        }
                                        linksnew.add(newurl.getUrlToCrawl());
                                    } else {
                                        //System.out.println("Breaking out - urls to crawl to the limit!!");
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (IOException e) {
                System.err.println("For '" + url1 + "': " + e.getMessage());
            }
        }
        finishCrawling();
    }

    public void finishCrawling() throws Exception {
        DogmaMainWindow.startButton.setBackground(new Color(238, 238, 238));
        write2DB = DogmaMainWindow.jRadioWrite2DB.isSelected();
        if (write2DB) {
            /*ConnectionDB.OpenConnection();
            System.out.println("Writing " + linksnew.size() + " Crawled URLs to Database");
            for (String item : linksnew) {
            ConnectionDB.dbCreateDomain(item);
            }*/
        }
        // ConnectionDB.CloseConnection();
    }
}
