/*
 * Written by Jaroslav Tulach, and released to the public domain,
 * as explained at http://creativecommons.org/publicdomain/zero/1.0/
 */
package org.ObjectLayout;

import java.io.FilePermission;
import java.lang.reflect.Member;
import java.security.Permission;
import static org.junit.Assert.assertNull;

class RestrictedSecurityManager extends SecurityManager {

    static void disable() {
        System.setSecurityManager(null);
        assertNull(System.getSecurityManager());
    }

    static void enable() {
        System.setSecurityManager(new RestrictedSecurityManager());
    }

    public RestrictedSecurityManager() {
    }

    @Override
    public void checkMemberAccess(Class<?> clazz, int which) {
        if (which == Member.DECLARED) {
        }
    }

    @Override
    public void checkPermission(Permission perm) {
        checkPermission(perm, null);
    }

    @Override
    public void checkPermission(Permission perm, Object context) {
        if (perm.getName().equals("createSecurityManager")) {
            return;
        }
        if (perm.getName().equals("setSecurityManager")) {
            return;
        }
        if (perm instanceof FilePermission) {
            return;
        }
        super.checkPermission(perm, context);
    }

    @Override
    public void checkPropertyAccess(String key) {
    }
    
}
