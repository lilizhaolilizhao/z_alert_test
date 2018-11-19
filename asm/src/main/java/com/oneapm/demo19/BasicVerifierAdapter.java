package com.oneapm.demo19;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.analysis.Analyzer;
import org.objectweb.asm.tree.analysis.AnalyzerException;
import org.objectweb.asm.tree.analysis.BasicValue;
import org.objectweb.asm.tree.analysis.BasicVerifier;

import static org.objectweb.asm.Opcodes.ASM4;

public class BasicVerifierAdapter extends MethodVisitor {
    String owner;
    MethodVisitor next;

    public BasicVerifierAdapter(String owner, int access, String name,
                                String desc, MethodVisitor mv) {
        super(ASM4, new MethodNode(access, name, desc, null, null));
        this.owner = owner;
        next = mv;
    }

    @Override
    public void visitEnd() {
        MethodNode mn = (MethodNode) mv;
        Analyzer<BasicValue> a = new Analyzer<>(new BasicVerifier());
        try {
            a.analyze(owner, mn);
        } catch (AnalyzerException e) {
            throw new RuntimeException(e.getMessage());
        }

        mn.accept(next);
    }
}
