package com.oneapm.demo17;

import org.objectweb.asm.tree.ClassNode;

public class ClassTransformer {
    private ClassTransformer ct;

    public ClassTransformer(ClassTransformer ct) {
        this.ct = ct;
    }

    public void transform(ClassNode cn) {
        if (ct != null) {
            ct.transform(cn);
        }
    }
}
