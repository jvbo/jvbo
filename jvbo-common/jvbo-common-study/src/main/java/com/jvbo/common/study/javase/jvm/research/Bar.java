/*
 * Bar.java 2018年1月16日
 * Copyright (c) 2015-2017, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.common.study.javase.jvm.research;

/**
 * 使用hsdis
 * @ClassName: Bar 
 * @Description: TODO 
 * @author jvbo
 * @date 2018年1月16日
 */
public class Bar {
    /**
     * 
1. [root@vm-centos-openjdk8 research]# jvbo-javac Bar.java
2. [root@vm-centos-openjdk8 java]# jvbo-java -XX:+PrintAssembly -Xcomp -XX:CompileCommand=dontinline,*Bar.sum -XX:CompileCommand=compileonly,*Bar.sum com.jvbo.common.study.javase.jvm.research.Bar
3. 结果
OpenJDK 64-Bit Server VM warning: PrintAssembly is enabled; turning on DebugNonSafepoints to gain additional output
CompilerOracle: dontinline *Bar.sum
CompilerOracle: compileonly *Bar.sum
Loaded disassembler from /opt/software/git/openjdk8/build/linux-x86_64-normal-server-fastdebug/jdk/lib/amd64/server/hsdis-amd64.so
Decoding compiled method 0x00007fa8651fd090:
Code:
[Disassembling for mach='i386:x86-64']
[Entry Point]
[Constants]
  # {method} {0x00007fa87abe42c0} 'sum' '(I)I' in 'com/jvbo/common/study/javase/jvm/research/Bar'
  # this:     rsi:rsi   = 'com/jvbo/common/study/javase/jvm/research/Bar'
  # parm0:    rdx       = int
  #           [sp+0x40]  (sp of caller)
  ;;  block B1 [0, 0]

  0x00007fa8651fd1e0: mov    0x8(%rsi),%r10d
  0x00007fa8651fd1e4: shl    $0x3,%r10
  0x00007fa8651fd1e8: cmp    %rax,%r10
  0x00007fa8651fd1eb: jne    0x00007fa865105be0  ;   {runtime_call}
  0x00007fa8651fd1f1: nop
  0x00007fa8651fd1f2: nop
  0x00007fa8651fd1f3: nop
  0x00007fa8651fd1f4: nop
  0x00007fa8651fd1f5: nop
  0x00007fa8651fd1f6: nop
  0x00007fa8651fd1f7: nop
  0x00007fa8651fd1f8: nop
  0x00007fa8651fd1f9: nop
  0x00007fa8651fd1fa: nop
  0x00007fa8651fd1fb: nop
  0x00007fa8651fd1fc: nop
  0x00007fa8651fd1fd: nop
  0x00007fa8651fd1fe: nop
  0x00007fa8651fd1ff: nop
[Verified Entry Point]
  0x00007fa8651fd200: mov    %eax,-0x16000(%rsp)
  0x00007fa8651fd207: push   %rbp
  0x00007fa8651fd208: sub    $0x30,%rsp
  0x00007fa8651fd20c: movabs $0x7fa87abe4598,%rax  ;   {metadata(method data for {method} {0x00007fa87abe42c0} 'sum' '(I)I' in 'com/jvbo/common/study/javase/jvm/research/Bar')}
  0x00007fa8651fd216: mov    0x6c(%rax),%edi
  0x00007fa8651fd219: add    $0x8,%edi
  0x00007fa8651fd21c: mov    %edi,0x6c(%rax)
  0x00007fa8651fd21f: movabs $0x7fa87abe42c0,%rax  ;   {metadata({method} {0x00007fa87abe42c0} 'sum' '(I)I' in 'com/jvbo/common/study/javase/jvm/research/Bar')}
  0x00007fa8651fd229: and    $0x0,%edi
  0x00007fa8651fd22c: cmp    $0x0,%edi
  ;;   22 branch [EQ] [CounterOverflowStub: 0x440219e8]
  0x00007fa8651fd22f: je     0x00007fa8651fd255  ;*aload_0
                                                ; - com.jvbo.common.study.javase.jvm.research.Bar::sum@0 (line 26)

  ;;  block B2 [0, 0]

  ;;  block B0 [0, 10]

  0x00007fa8651fd235: mov    0xc(%rsi),%eax     ;*getfield a
                                                ; - com.jvbo.common.study.javase.jvm.research.Bar::sum@1 (line 26)

  0x00007fa8651fd238: movabs $0xe8e86e30,%rsi   ;   {oop(a 'java/lang/Class' = 'com/jvbo/common/study/javase/jvm/research/Bar')}
  0x00007fa8651fd242: mov    0x60(%rsi),%esi    ;*getstatic b
                                                ; - com.jvbo.common.study.javase.jvm.research.Bar::sum@4 (line 26)

  0x00007fa8651fd245: add    %esi,%eax
  0x00007fa8651fd247: add    %edx,%eax
  0x00007fa8651fd249: add    $0x30,%rsp
  0x00007fa8651fd24d: pop    %rbp
  0x00007fa8651fd24e: test   %eax,0x19223eac(%rip)        # 0x00007fa87e421100
                                                ;   {poll_return}
  0x00007fa8651fd254: retq   
  ;; CounterOverflowStub slow case
  0x00007fa8651fd255: mov    %rax,0x8(%rsp)
  0x00007fa8651fd25a: movq   $0xffffffffffffffff,(%rsp)
  0x00007fa8651fd262: callq  0x00007fa8651cab80  ; OopMap{rsi=Oop off=135}
                                                ;*synchronization entry
                                                ; - com.jvbo.common.study.javase.jvm.research.Bar::sum@-1 (line 26)
                                                ;   {runtime_call}
  0x00007fa8651fd267: jmp    0x00007fa8651fd235
  0x00007fa8651fd269: nop
  0x00007fa8651fd26a: nop
  ;; Unwind handler
  0x00007fa8651fd26b: mov    0x2c8(%r15),%rax
  0x00007fa8651fd272: movabs $0x0,%r10
  0x00007fa8651fd27c: mov    %r10,0x2c8(%r15)
  0x00007fa8651fd283: movabs $0x0,%r10
  0x00007fa8651fd28d: mov    %r10,0x2d0(%r15)
  0x00007fa8651fd294: add    $0x30,%rsp
  0x00007fa8651fd298: pop    %rbp
  0x00007fa8651fd299: jmpq   0x00007fa865134c40  ;   {runtime_call}
  0x00007fa8651fd29e: hlt    
  0x00007fa8651fd29f: hlt    
[Exception Handler]
[Stub Code]
  0x00007fa8651fd2a0: movabs $0xdead,%rbx       ;   {no_reloc}
  0x00007fa8651fd2aa: movabs $0xdead,%rcx
  0x00007fa8651fd2b4: movabs $0xdead,%rsi
  0x00007fa8651fd2be: movabs $0xdead,%rdi
  0x00007fa8651fd2c8: callq  0x00007fa8651c69a0  ;   {runtime_call}
  0x00007fa8651fd2cd: mov    %rsp,-0x28(%rsp)
  0x00007fa8651fd2d2: sub    $0x80,%rsp
  0x00007fa8651fd2d9: mov    %rax,0x78(%rsp)
  0x00007fa8651fd2de: mov    %rcx,0x70(%rsp)
  0x00007fa8651fd2e3: mov    %rdx,0x68(%rsp)
  0x00007fa8651fd2e8: mov    %rbx,0x60(%rsp)
  0x00007fa8651fd2ed: mov    %rbp,0x50(%rsp)
  0x00007fa8651fd2f2: mov    %rsi,0x48(%rsp)
  0x00007fa8651fd2f7: mov    %rdi,0x40(%rsp)
  0x00007fa8651fd2fc: mov    %r8,0x38(%rsp)
  0x00007fa8651fd301: mov    %r9,0x30(%rsp)
  0x00007fa8651fd306: mov    %r10,0x28(%rsp)
  0x00007fa8651fd30b: mov    %r11,0x20(%rsp)
  0x00007fa8651fd310: mov    %r12,0x18(%rsp)
  0x00007fa8651fd315: mov    %r13,0x10(%rsp)
  0x00007fa8651fd31a: mov    %r14,0x8(%rsp)
  0x00007fa8651fd31f: mov    %r15,(%rsp)
  0x00007fa8651fd323: movabs $0x7fa87d2122fb,%rdi  ;   {external_word}
  0x00007fa8651fd32d: movabs $0x7fa8651fd2cd,%rsi  ;   {internal_word}
  0x00007fa8651fd337: mov    %rsp,%rdx
  0x00007fa8651fd33a: and    $0xfffffffffffffff0,%rsp
  0x00007fa8651fd33e: callq  0x00007fa87cd729a0  ;   {runtime_call}
  0x00007fa8651fd343: hlt    
[Deopt Handler Code]
  0x00007fa8651fd344: movabs $0x7fa8651fd344,%r10  ;   {section_word}
  0x00007fa8651fd34e: push   %r10
  0x00007fa8651fd350: jmpq   0x00007fa8651071a0  ;   {runtime_call}
  0x00007fa8651fd355: hlt    
  0x00007fa8651fd356: hlt    
  0x00007fa8651fd357: hlt    
Decoding compiled method 0x00007fa8651fcd50:
Code:
[Entry Point]
[Constants]
  # {method} {0x00007fa87abe42c0} 'sum' '(I)I' in 'com/jvbo/common/study/javase/jvm/research/Bar'
  # this:     rsi:rsi   = 'com/jvbo/common/study/javase/jvm/research/Bar'
  # parm0:    rdx       = int
  #           [sp+0x40]  (sp of caller)
  ;;  block B1 [0, 0]

  0x00007fa8651fcea0: mov    0x8(%rsi),%r10d
  0x00007fa8651fcea4: shl    $0x3,%r10
  0x00007fa8651fcea8: cmp    %rax,%r10
  0x00007fa8651fceab: jne    0x00007fa865105be0  ;   {runtime_call}
  0x00007fa8651fceb1: nop
  0x00007fa8651fceb2: nop
  0x00007fa8651fceb3: nop
  0x00007fa8651fceb4: nop
  0x00007fa8651fceb5: nop
  0x00007fa8651fceb6: nop
  0x00007fa8651fceb7: nop
  0x00007fa8651fceb8: nop
  0x00007fa8651fceb9: nop
  0x00007fa8651fceba: nop
  0x00007fa8651fcebb: nop
  0x00007fa8651fcebc: nop
  0x00007fa8651fcebd: nop
  0x00007fa8651fcebe: nop
  0x00007fa8651fcebf: nop
[Verified Entry Point]
  0x00007fa8651fcec0: mov    %eax,-0x16000(%rsp)
  0x00007fa8651fcec7: push   %rbp
  0x00007fa8651fcec8: sub    $0x30,%rsp         ;*aload_0
                                                ; - com.jvbo.common.study.javase.jvm.research.Bar::sum@0 (line 26)

  ;;  block B0 [0, 10]

  0x00007fa8651fcecc: mov    0xc(%rsi),%eax     ;*getfield a
                                                ; - com.jvbo.common.study.javase.jvm.research.Bar::sum@1 (line 26)

  0x00007fa8651fcecf: movabs $0xe8e86e30,%rsi   ;   {oop(a 'java/lang/Class' = 'com/jvbo/common/study/javase/jvm/research/Bar')}
  0x00007fa8651fced9: mov    0x60(%rsi),%esi    ;*getstatic b
                                                ; - com.jvbo.common.study.javase.jvm.research.Bar::sum@4 (line 26)

  0x00007fa8651fcedc: add    %esi,%eax
  0x00007fa8651fcede: add    %edx,%eax
  0x00007fa8651fcee0: add    $0x30,%rsp
  0x00007fa8651fcee4: pop    %rbp
  0x00007fa8651fcee5: test   %eax,0x19224215(%rip)        # 0x00007fa87e421100
                                                ;   {poll_return}
  0x00007fa8651fceeb: retq   
  0x00007fa8651fceec: nop
  0x00007fa8651fceed: nop
  ;; Unwind handler
  0x00007fa8651fceee: mov    0x2c8(%r15),%rax
  0x00007fa8651fcef5: movabs $0x0,%r10
  0x00007fa8651fceff: mov    %r10,0x2c8(%r15)
  0x00007fa8651fcf06: movabs $0x0,%r10
  0x00007fa8651fcf10: mov    %r10,0x2d0(%r15)
  0x00007fa8651fcf17: add    $0x30,%rsp
  0x00007fa8651fcf1b: pop    %rbp
  0x00007fa8651fcf1c: jmpq   0x00007fa865134c40  ;   {runtime_call}
  0x00007fa8651fcf21: hlt    
  0x00007fa8651fcf22: hlt    
  0x00007fa8651fcf23: hlt    
  0x00007fa8651fcf24: hlt    
  0x00007fa8651fcf25: hlt    
  0x00007fa8651fcf26: hlt    
  0x00007fa8651fcf27: hlt    
  0x00007fa8651fcf28: hlt    
  0x00007fa8651fcf29: hlt    
  0x00007fa8651fcf2a: hlt    
  0x00007fa8651fcf2b: hlt    
  0x00007fa8651fcf2c: hlt    
  0x00007fa8651fcf2d: hlt    
  0x00007fa8651fcf2e: hlt    
  0x00007fa8651fcf2f: hlt    
  0x00007fa8651fcf30: hlt    
  0x00007fa8651fcf31: hlt    
  0x00007fa8651fcf32: hlt    
  0x00007fa8651fcf33: hlt    
  0x00007fa8651fcf34: hlt    
  0x00007fa8651fcf35: hlt    
  0x00007fa8651fcf36: hlt    
  0x00007fa8651fcf37: hlt    
  0x00007fa8651fcf38: hlt    
  0x00007fa8651fcf39: hlt    
  0x00007fa8651fcf3a: hlt    
  0x00007fa8651fcf3b: hlt    
  0x00007fa8651fcf3c: hlt    
  0x00007fa8651fcf3d: hlt    
  0x00007fa8651fcf3e: hlt    
  0x00007fa8651fcf3f: hlt    
[Exception Handler]
[Stub Code]
  0x00007fa8651fcf40: movabs $0xdead,%rbx       ;   {no_reloc}
  0x00007fa8651fcf4a: movabs $0xdead,%rcx
  0x00007fa8651fcf54: movabs $0xdead,%rsi
  0x00007fa8651fcf5e: movabs $0xdead,%rdi
  0x00007fa8651fcf68: callq  0x00007fa8651c69a0  ;   {runtime_call}
  0x00007fa8651fcf6d: mov    %rsp,-0x28(%rsp)
  0x00007fa8651fcf72: sub    $0x80,%rsp
  0x00007fa8651fcf79: mov    %rax,0x78(%rsp)
  0x00007fa8651fcf7e: mov    %rcx,0x70(%rsp)
  0x00007fa8651fcf83: mov    %rdx,0x68(%rsp)
  0x00007fa8651fcf88: mov    %rbx,0x60(%rsp)
  0x00007fa8651fcf8d: mov    %rbp,0x50(%rsp)
  0x00007fa8651fcf92: mov    %rsi,0x48(%rsp)
  0x00007fa8651fcf97: mov    %rdi,0x40(%rsp)
  0x00007fa8651fcf9c: mov    %r8,0x38(%rsp)
  0x00007fa8651fcfa1: mov    %r9,0x30(%rsp)
  0x00007fa8651fcfa6: mov    %r10,0x28(%rsp)
  0x00007fa8651fcfab: mov    %r11,0x20(%rsp)
  0x00007fa8651fcfb0: mov    %r12,0x18(%rsp)
  0x00007fa8651fcfb5: mov    %r13,0x10(%rsp)
  0x00007fa8651fcfba: mov    %r14,0x8(%rsp)
  0x00007fa8651fcfbf: mov    %r15,(%rsp)
  0x00007fa8651fcfc3: movabs $0x7fa87d2122fb,%rdi  ;   {external_word}
  0x00007fa8651fcfcd: movabs $0x7fa8651fcf6d,%rsi  ;   {internal_word}
  0x00007fa8651fcfd7: mov    %rsp,%rdx
  0x00007fa8651fcfda: and    $0xfffffffffffffff0,%rsp
  0x00007fa8651fcfde: callq  0x00007fa87cd729a0  ;   {runtime_call}
  0x00007fa8651fcfe3: hlt    
[Deopt Handler Code]
  0x00007fa8651fcfe4: movabs $0x7fa8651fcfe4,%r10  ;   {section_word}
  0x00007fa8651fcfee: push   %r10
  0x00007fa8651fcff0: jmpq   0x00007fa8651071a0  ;   {runtime_call}
  0x00007fa8651fcff5: hlt    
  0x00007fa8651fcff6: hlt    
  0x00007fa8651fcff7: hlt    
     */
    int a = 1;
    static int b = 2;
    
    public int sum(int c){
        return a + b + c;   
    }

    public static void main(String[] args) {
        new Bar().sum(3);
    }

}
