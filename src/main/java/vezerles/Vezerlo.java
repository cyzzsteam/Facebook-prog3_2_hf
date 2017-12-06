/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vezerles;

import feluletek.FejlecPanel;
import feluletek.FelhasznalokPanel;
import feluletek.KozossegiPanel;

/**
 *
 * @author varga
 */
public class Vezerlo {

    private KozossegiPanel kozossegiPanel;
    private FelhasznalokPanel felhasznalokPanel;
    private FejlecPanel fejlecPanel;

    public Vezerlo(KozossegiPanel kozossegiPanel, FelhasznalokPanel felhasznalokPanel, FejlecPanel fejlecPanel) {
        this.kozossegiPanel = kozossegiPanel;
        this.felhasznalokPanel = felhasznalokPanel;
        this.fejlecPanel = fejlecPanel;
    }

    void start() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
