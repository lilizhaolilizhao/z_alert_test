package com.oneapm.demo18;

import org.objectweb.asm.tree.MethodNode;

public class MethodTransformer {
    private MethodTransformer ct;

    public MethodTransformer(MethodTransformer ct) {
        this.ct = ct;
    }

    public void transform(MethodNode cn) {
        if (ct != null) {
            ct.transform(cn);
        }
    }
}
