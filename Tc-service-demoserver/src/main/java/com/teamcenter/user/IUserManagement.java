package com.teamcenter.user;

import com.teamcenter.clientx.AppXSession;
import com.teamcenter.services.strong.administration.UserManagementService;
import com.teamcenter.services.strong.administration._2015_07.UserManagement;
import com.teamcenter.soa.client.Connection;
import com.teamcenter.soa.client.model.strong.User;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.HashMap;


@Service
public class IUserManagement {



    public static void mutliCretionUsers() {

        String serverHost = "http://192.168.1.108:7001/tc";
        AppXSession session = new AppXSession(serverHost);

        Connection connection = session.getConnection();

        User user = session.login();

        for(int i=2; i< 100; i++) {
            createUser("Job_" + i, connection);
            System.out.println("--> 已创建用户_" + i);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i % 20 == 0) {
                session.logout();
                System.out.println("Logout and Login");
                session.login();
            }
        }

        session.logout();

    }


    public static void createUser(String username, Connection connection)
    {




//        ISessionService iss = null;
//        TCSession localTCSession = null;
//
//        try
//        {
//            localTCSession = (TCSession)iss.getSession(TCSession.class.getName());
//            if ((!localTCSession.isUserSystemAdmin()) && (!localTCSession.isUserAuthorizedForApplication("Organization")))
//            {
//                return null;
//            }
//        }
//        catch (Exception localException1)
//        {
//            return null;
//        }


        String str1 = username; //user name
        String str2 = username; //user id
        String str3 = "123"; //password
        String str4 = "Windows"; //os name

//        TCComponentGroup localTCComponentGroup = getDefaultGroup(localTCSession)[0];
//        TCComponentVolume localTCComponentVolume1 = null;
//        TCComponentVolume localTCComponentVolume2 = null;
//        TCComponentRole localTCComponentRole = getRole("", localTCSession)[0];
//
//        TCComponentPersonType localTCComponentPersonType = null;
//        TCComponentPerson localTCComponentPerson = null;
//        TCComponentUserType localTCComponentUserType = null;
//        UserList localUserList = null;
//        try
//        {
//            localTCComponentPersonType = (TCComponentPersonType) localTCSession.getTypeComponent("Person");
//            localTCComponentPerson = localTCComponentPersonType.find(str1);
//        }
//        catch (TCException localTCException2) {
//
//        }
//        int i;
//        if (localTCComponentPerson != null) {
//            try
//            {
//                localTCComponentUserType = (TCComponentUserType) localTCSession.getTypeComponent("User");
//                localUserList = localTCComponentUserType.getUserListByUser(str1);
//                if ((localUserList.getUserIds() != null) && (localUserList.getUserIds().length > 0))
//                {
//
//                    return null;
//                }
//            }
//            catch (TCException localTCException3) {}
//        }
//        Object localObject1 = null;
        try
        {
//            i = 0;
//            if (localOrgUserWizardAddNewUserPanel.getconsumerUserButton().isSelected()) {
//                i = 1;
//            } else if (localOrgUserWizardAddNewUserPanel.getoccasionalUserButton().isSelected()) {
//                i = 2;
//            } else if (localOrgUserWizardAddNewUserPanel.getviewerUserButton().isSelected()) {
//                i = 3;
//            } else if (localOrgUserWizardAddNewUserPanel.getadminUserButton().isSelected()) {
//                i = 5;
//            } else {
//                i = 0;
//            }

            String str5 = "";  //license server
            String str6 = "";  //license bundle

            UserManagementService localUserManagementService = UserManagementService.getService(connection);
            UserManagement.CreateOrUpdateUserInputs[] arrayOfCreateOrUpdateUserInputs = new UserManagement.CreateOrUpdateUserInputs[1];
            arrayOfCreateOrUpdateUserInputs[0] = new UserManagement.CreateOrUpdateUserInputs();
            arrayOfCreateOrUpdateUserInputs[0].userId = str2;
            arrayOfCreateOrUpdateUserInputs[0].password = str3;
            arrayOfCreateOrUpdateUserInputs[0].person = str1;
            arrayOfCreateOrUpdateUserInputs[0].defaultGroup = "system";
            HashMap localHashMap = new HashMap();
            localHashMap.put("os_username", new String[] { str4 });
            localHashMap.put("SOA_operation", new String[] { "CREATE" });
            localHashMap.put("license_level", new String[] { Integer.toString(2) });
//            if (localTCComponentVolume1 != null) {
//                localHashMap.put("volume", new String[] { localTCComponentVolume1.toString() });
//            }
//            if (localTCComponentVolume2 != null) {
//                localHashMap.put("local_volume", new String[] { localTCComponentVolume2.toString() });
//            }
//            if (localTCComponentRole != null) {
//                localHashMap.put("role", new String[] { localTCComponentRole.getProperty("role_name") });
//            }
//            localHashMap.put("volume", new String[] { "" });
//            localHashMap.put("local_volume", new String[] { "" });
            localHashMap.put("role", new String[] { "Developer" });

            if ((str5 != null) && (str5.length() > 0)) {
                localHashMap.put("license_bundle", new String[] { str5 });
            }
            if ((str6 != null) && (str6.length() > 0)) {
                localHashMap.put("license_server", new String[] { str6 });
            }
            arrayOfCreateOrUpdateUserInputs[0].userPropertyMap = localHashMap;
            Object localObject4;

            if (true)
            {
//                localObject2 = (OrgUserWizardAddNewCUPPanel)this.m_panel.getPanel((short)3);
//                localObject3 = ((OrgUserWizardAddNewCUPPanel)localObject2).getPropertyCompMap();
//                localObject4 = CustomUserProfileHelper.getUIValuesFromComponents(loalTCSession, (Map)localObject3, null);
//                arrayOfCreateOrUpdateUserInputs[0].userAddlPropertyMap = ((Map)localcObject4);
//                ((OrgUserWizardAddNewCUPPanel)localObject2).flushComponents();
            }
            Object localObject2 = localUserManagementService.createOrUpdateUser(arrayOfCreateOrUpdateUserInputs);


//            Object localObject3 = (UserManagement.UserObjectStructure)((UserManagement.CreateOrUpdateUserResponse)localObject2).userObjectMap.get(arrayOfCreateOrUpdateUserInputs[0].userId);
//            if (localObject3 != null)
//            {
//                localObject1 = ((IUserManagement.UserObjectStructure)localObject3).user;
//                ((TCComponentUser)localObject1).fireComponentCreateEvent();
//                localObject4 = ((TCComponentUser)localObject1).getGroupMembers();
//                if ((localObject4 != null) && (localObject4.length > 0))
//                {
//                    localObject4[0].fireComponentCreateEvent();
//                    localTCComponentRole = localObject4[0].getRole();
//                    if (localTCComponentRole != null) {
//                        localTCComponentRole.fireComponentChangeEvent();
//                    }
//                }
//            }
        }
        catch (Exception localTCException1)
        {
            try
            {
                SwingUtilities.invokeAndWait(null);
            }
            catch (Exception localException2)
            {
                localException2.printStackTrace();
            }
        }



    }

//    private static  boolean getAddNewCUPFlag() {
//        return true;
//    }
//
//    private static TCComponentRole[] getRole(String rolename, TCSession localTCSession) {
//        TCComponentRole[] arrayOfTCComponentRole = new TCComponentRole[1];
//        try
//        {
//            TCComponentRoleType localTCComponentRoleType = (TCComponentRoleType)localTCSession.getTypeComponent("Role");
//            for (int j = 0; j < 1; j++) {
//                arrayOfTCComponentRole[j] = localTCComponentRoleType.find( rolename );
//            }
//            return arrayOfTCComponentRole;
//        }
//        catch (TCException localTCException) {
//
//        }
//        return null;
//
//    }
//
//
//    private static TCComponentGroup[] getDefaultGroup(TCSession localTCSession) {
//        TCComponentGroup[] arrayOfTCComponentGroup = new TCComponentGroup[1];
//        try
//        {
//            TCComponentGroupType localTCComponentGroupType = (TCComponentGroupType)localTCSession.getTypeComponent("Group");
//            for (int j = 0; j < 1; j++)
//            {
//                String str = "system";
//                arrayOfTCComponentGroup[j] = localTCComponentGroupType.find(str);
//            }
//            return arrayOfTCComponentGroup;
//        }
//        catch (TCException localTCException) {}
//        return null;
//    }

}
