package dogma.gui;

public class UrlToCrawl {

    private final String urlToCrawl;
    private boolean urlIsCrawled;
    private int depth;

    public UrlToCrawl(String urlToCrawl, int depth, boolean urlIsCrawled) {
        this.urlToCrawl = urlToCrawl;
        this.depth = depth;
        this.urlIsCrawled = urlIsCrawled;
    }

    public String getUrlToCrawl() {
        return urlToCrawl;
    }
    
    public Integer getDepth() {
        return depth;
    }

    public boolean getUrlIsCrawled() {
        return urlIsCrawled;
    }

    public void setUrlIsCrawled(boolean urlIsCrawled) {
        this.urlIsCrawled = urlIsCrawled;
    }

}
