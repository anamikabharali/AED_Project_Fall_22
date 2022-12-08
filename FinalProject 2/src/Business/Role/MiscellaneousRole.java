
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.CanteenOrganization;
import Business.Organization.MiscellaneousOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.ResidentialHall.Canteen.CanteenWorkAreaJPanel;
import userinterface.ResidentialHall.Miscellaneous.MiscellaneousWorkAreaJPanel;

/**
 *
 * @author srivaishnaviaekkati
 */
public class MiscellaneousRole extends Role {

   
     
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, 
            Organization organization, Enterprise enterprise, EcoSystem business,Network network) {
   return new MiscellaneousWorkAreaJPanel(userProcessContainer, account,(MiscellaneousOrganization) 
           organization,enterprise, business,network);
    }
     @Override
    public String toString(){
        return RoleType.Miscellaneous.getValue();
    }
    
}
