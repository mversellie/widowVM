package com.widowvm.widowvm.create.kickstart;

import java.util.ArrayList;
import java.util.Arrays;

public class KickStartExpectedListMother {
    static ArrayList<String> generateExpectedDefaultList() {
        String stringNotList[] = new String[]{
                "lang en_US",
                "langsupport en_US",
                "keyboard us",
                "mouse",
                "timezone America/New_York",
                "rootpw --disabled",
                "user --disabled",
                "reboot",
                "text",
                "install",
                "cdrom",
                "bootloader --location=mbr",
                "zerombr yes",
                "clearpart --all --initlabel",
                "part swap --size 1024",
                "part /boot --fstype ext4 --size 256 --asprimary",
                "part / --fstype ext4 --size 1 --grow --asprimary",
                "auth  --useshadow  --enablemd5",
                "network --bootproto=dhcp --device=eth0",
                "firewall --disabled --trust=eth0 --ssh",
                "skipx",
                "preseed user-setup/allow-password-weak boolean true"
        };

        return  new ArrayList<String>(Arrays.asList(stringNotList));
    }

    static ArrayList<String> generateExpectedOptionsList() {
        String stringNotList[] = new String[]{
                "lang en_US",
                "langsupport en_US",
                "keyboard us",
                "mouse",
                "timezone America/New_York",
                "rootpw --iscrypted rootPassword!",
                "user testUser --password sudoPass --fullname aFullName",
                "reboot",
                "text",
                "install",
                "cdrom",
                "bootloader --location=mbr",
                "zerombr yes",
                "clearpart --all --initlabel",
                "part swap --size 1024",
                "part /boot --fstype ext4 --size 256 --asprimary",
                "part / --fstype ext4 --size 1 --grow --asprimary",
                "auth  --useshadow  --enablemd5",
                "network --bootproto=dhcp --device=eth0",
                "firewall --disabled --trust=eth0 --ssh",
                "skipx",
                "preseed user-setup/allow-password-weak boolean true"
        };

        return  new ArrayList<String>(Arrays.asList(stringNotList));
    }
}
