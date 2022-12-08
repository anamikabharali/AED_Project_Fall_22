/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.CanteenRole;
import Business.Role.MiscellaneousRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author srivaishnaviaekkati
 */
public class MiscellaneousOrganization extends Organization {

    public MiscellaneousOrganization() {
        super(Organization.Type.Miscellaneous.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new MiscellaneousRole());
        return roles;
    }
}
