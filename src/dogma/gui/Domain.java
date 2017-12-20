/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dogma.gui;

import static dogma.gui.CommonBal.sha256;
import java.sql.Timestamp;

/**
 *
 * @author arjen
 */
public class Domain {
    private String domainHash;
    private String domainUrl;
    private boolean activated;
    private Timestamp created;
    private Timestamp modified;    

    public String getDomainHash() {
        return domainHash;
    }

    public String getDomainUrl() {
        return domainUrl;
    }

    public boolean isActivated() {
        return activated;
    }

    public Timestamp getCreated() {
        return created;
    }

    public Timestamp getModified() {
        return modified;
    }
    
    public Domain(String domainUrl) throws Exception {
        this.domainHash = sha256(domainUrl);
        this.domainUrl = domainUrl;
        this.modified = CommonBal.getTimestamp();
        this.created = CommonBal.getTimestamp();
        this.activated = true;
    }
    
    public Domain(String domainHash, String domainUrl) {
        this.domainHash = domainHash;
        this.domainUrl = domainUrl;
    }
    
    /* used mainly when reading data from DB */
    public Domain(String domainHash, String domainUrl, boolean activated, Timestamp created, Timestamp modified) {
        this.domainHash = domainHash;
        this.domainUrl = domainUrl;
        this.activated = activated;
        this.created = created;
        this.modified = modified;
    }
}
