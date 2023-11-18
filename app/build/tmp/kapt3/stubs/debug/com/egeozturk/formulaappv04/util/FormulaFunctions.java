package com.egeozturk.formulaappv04.util;

import kotlin.math.*;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\bN\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b*\n\u0002\u0010\u000b\n\u0003\b\u009c\u0001\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0016\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0003\"\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0011J\u0006\u0010\u0015\u001a\u00020\u0011J\u0006\u0010\u0016\u001a\u00020\u0011J\u0006\u0010\u0017\u001a\u00020\u0011J\u0006\u0010\u0018\u001a\u00020\u0011J\u0006\u0010\u0019\u001a\u00020\u0011J\u0006\u0010\u001a\u001a\u00020\u0011J\u0006\u0010\u001b\u001a\u00020\u0011J\u0006\u0010\u001c\u001a\u00020\u0011J\u0006\u0010\u001d\u001a\u00020\u0011J\u0006\u0010\u001e\u001a\u00020\u0011J\u0006\u0010\u001f\u001a\u00020\u0011J\u0006\u0010 \u001a\u00020\u0011J\u0006\u0010!\u001a\u00020\u0011J\u0006\u0010\"\u001a\u00020\u0011J\u0006\u0010#\u001a\u00020\u0011J\u0006\u0010$\u001a\u00020\u0011J\u0006\u0010%\u001a\u00020\u0011J\u0006\u0010&\u001a\u00020\u0011J\u0006\u0010\'\u001a\u00020\u0011J\u0006\u0010(\u001a\u00020\u0011J\u0006\u0010)\u001a\u00020\u0011J\u0006\u0010*\u001a\u00020\u0011J\u0006\u0010+\u001a\u00020\u0011J\u0006\u0010,\u001a\u00020\u0011J\u0006\u0010-\u001a\u00020\u0011J\u0006\u0010.\u001a\u00020\u0011J\u0006\u0010/\u001a\u00020\u0011J\u0006\u00100\u001a\u00020\u0011J\u0006\u00101\u001a\u00020\u0011J\u0006\u00102\u001a\u00020\u0011J\u0006\u00103\u001a\u00020\u0011J\u0006\u00104\u001a\u00020\u0011J\u0006\u00105\u001a\u00020\u0011J\u0006\u00106\u001a\u00020\u0011J\u0006\u00107\u001a\u00020\u0011J\u0006\u00108\u001a\u00020\u0011J\u0006\u00109\u001a\u00020\u0011J\u0006\u0010:\u001a\u00020\u0011J\u0006\u0010;\u001a\u00020\u0011J\u0006\u0010<\u001a\u00020\u0011J\u0006\u0010=\u001a\u00020\u0011J\u0006\u0010>\u001a\u00020\u0011J\u0006\u0010?\u001a\u00020\u0011J\u0006\u0010@\u001a\u00020\u0011J\u0006\u0010A\u001a\u00020\u0011J\u0006\u0010B\u001a\u00020\u0011J\u0006\u0010C\u001a\u00020\u0011J\u0006\u0010D\u001a\u00020\u0011J\u0006\u0010E\u001a\u00020\u0011J\u0006\u0010F\u001a\u00020\u0011J\u0006\u0010G\u001a\u00020\u0011J\u0006\u0010H\u001a\u00020\u0011J\u0006\u0010I\u001a\u00020\u0011J\u0006\u0010J\u001a\u00020\u0011J\u0006\u0010K\u001a\u00020\u0011J\u0006\u0010L\u001a\u00020\u0011J\u0006\u0010M\u001a\u00020\u0011J\u0006\u0010N\u001a\u00020\u0011J\u0006\u0010O\u001a\u00020\u0011J\u0006\u0010P\u001a\u00020\u0011J\u0006\u0010Q\u001a\u00020\u0011J\u0006\u0010R\u001a\u00020\u0011J\u0006\u0010S\u001a\u00020\u0011J\u0006\u0010T\u001a\u00020\u0011J\u0010\u0010U\u001a\u00020\u00042\u0006\u0010V\u001a\u00020\u0004H\u0002J\u0006\u0010W\u001a\u00020\u0011J\u0006\u0010X\u001a\u00020\u0011J\u0006\u0010Y\u001a\u00020\u0011J\u0006\u0010Z\u001a\u00020\u0011J\u0006\u0010[\u001a\u00020\u0011J\u0006\u0010\\\u001a\u00020\u0011J\u0006\u0010]\u001a\u00020\u0011J\u0006\u0010^\u001a\u00020\u0011J \u0010_\u001a\u0012\u0012\u0004\u0012\u00020\u00060`j\b\u0012\u0004\u0012\u00020\u0006`a2\u0006\u0010b\u001a\u00020\u0004H\u0002J \u0010c\u001a\u0012\u0012\u0004\u0012\u00020d0`j\b\u0012\u0004\u0012\u00020d`a2\u0006\u0010e\u001a\u00020dH\u0002J\u0006\u0010f\u001a\u00020\u0011J\u0006\u0010g\u001a\u00020\u0011J\u0006\u0010h\u001a\u00020\u0011J\u0006\u0010i\u001a\u00020\u0011J\u0006\u0010j\u001a\u00020\u0011J\u0006\u0010k\u001a\u00020\u0011J\u0006\u0010l\u001a\u00020\u0011J\u0006\u0010m\u001a\u00020\u0011J\u0006\u0010n\u001a\u00020\u0011J\u0006\u0010o\u001a\u00020\u0011J\u0018\u0010p\u001a\u00020d2\u0006\u0010q\u001a\u00020\u00042\u0006\u0010r\u001a\u00020\u0004H\u0002J\u0006\u0010s\u001a\u00020\u0011J\u0006\u0010t\u001a\u00020\u0011J\u0006\u0010u\u001a\u00020\u0011J\u0006\u0010v\u001a\u00020\u0011J\u0006\u0010w\u001a\u00020\u0011J\u0006\u0010x\u001a\u00020\u0011J\u0006\u0010y\u001a\u00020\u0011J\u0006\u0010z\u001a\u00020\u0011J\u0006\u0010{\u001a\u00020\u0011J\u0006\u0010|\u001a\u00020\u0011J\u0006\u0010}\u001a\u00020\u0011J\u0006\u0010~\u001a\u00020\u0011J\u0006\u0010\u007f\u001a\u00020\u0011J\u0007\u0010\u0080\u0001\u001a\u00020\u0011J\u0007\u0010\u0081\u0001\u001a\u00020\u0011J\u0007\u0010\u0082\u0001\u001a\u00020\u0011J\u0007\u0010\u0083\u0001\u001a\u00020\u0011J\u0007\u0010\u0084\u0001\u001a\u00020\u0011J\u0007\u0010\u0085\u0001\u001a\u00020\u0011J\u0007\u0010\u0086\u0001\u001a\u00020\u0011J\u0007\u0010\u0087\u0001\u001a\u00020\u0011J\u0007\u0010\u0088\u0001\u001a\u00020\u0011J\u0007\u0010\u0089\u0001\u001a\u00020\u0011J\u0007\u0010\u008a\u0001\u001a\u00020\u0011J\u0007\u0010\u008b\u0001\u001a\u00020\u0011J\u0007\u0010\u008c\u0001\u001a\u00020\u0011J\u0007\u0010\u008d\u0001\u001a\u00020\u0011J\u0012\u0010\u008e\u0001\u001a\u00030\u008f\u00012\u0006\u0010b\u001a\u00020\u0004H\u0002J\u0007\u0010\u0090\u0001\u001a\u00020\u0011J\u0007\u0010\u0091\u0001\u001a\u00020\u0011J\u0007\u0010\u0092\u0001\u001a\u00020\u0011J\u0007\u0010\u0093\u0001\u001a\u00020\u0011J\u0007\u0010\u0094\u0001\u001a\u00020\u0011J\u0007\u0010\u0095\u0001\u001a\u00020\u0011J\u0019\u0010\u0096\u0001\u001a\u00020d2\u0006\u0010q\u001a\u00020\u00042\u0006\u0010r\u001a\u00020\u0004H\u0002J\u0007\u0010\u0097\u0001\u001a\u00020\u0011J\u0007\u0010\u0098\u0001\u001a\u00020\u0011J\u0007\u0010\u0099\u0001\u001a\u00020\u0011J\u0007\u0010\u009a\u0001\u001a\u00020\u0011J\u0007\u0010\u009b\u0001\u001a\u00020\u0011J\u0007\u0010\u009c\u0001\u001a\u00020\u0011J\u0007\u0010\u009d\u0001\u001a\u00020\u0011J\u0007\u0010\u009e\u0001\u001a\u00020\u0011J\u0007\u0010\u009f\u0001\u001a\u00020\u0011J\u0007\u0010\u00a0\u0001\u001a\u00020\u0011J\u0007\u0010\u00a1\u0001\u001a\u00020\u0011J\u0007\u0010\u00a2\u0001\u001a\u00020\u0011J\u0007\u0010\u00a3\u0001\u001a\u00020\u0011J\u0007\u0010\u00a4\u0001\u001a\u00020\u0011J\u0007\u0010\u00a5\u0001\u001a\u00020\u0011J\u0007\u0010\u00a6\u0001\u001a\u00020\u0011J\u0007\u0010\u00a7\u0001\u001a\u00020\u0011J\u0007\u0010\u00a8\u0001\u001a\u00020\u0011J\u0007\u0010\u00a9\u0001\u001a\u00020\u0011J\u0007\u0010\u00aa\u0001\u001a\u00020\u0011J\u0007\u0010\u00ab\u0001\u001a\u00020\u0011J\u0007\u0010\u00ac\u0001\u001a\u00020\u0011J\u0007\u0010\u00ad\u0001\u001a\u00020\u0011J\u0007\u0010\u00ae\u0001\u001a\u00020\u0011J\u0007\u0010\u00af\u0001\u001a\u00020\u0011J\u0007\u0010\u00b0\u0001\u001a\u00020\u0011J\u0007\u0010\u00b1\u0001\u001a\u00020\u0011J\u0007\u0010\u00b2\u0001\u001a\u00020\u0011J\u0007\u0010\u00b3\u0001\u001a\u00020\u0011J\u0007\u0010\u00b4\u0001\u001a\u00020\u0011J\u0007\u0010\u00b5\u0001\u001a\u00020\u0011J\u0007\u0010\u00b6\u0001\u001a\u00020\u0011J\u0007\u0010\u00b7\u0001\u001a\u00020\u0011J\u0007\u0010\u00b8\u0001\u001a\u00020\u0011J\u0007\u0010\u00b9\u0001\u001a\u00020\u0011J\u0007\u0010\u00ba\u0001\u001a\u00020\u0011J\u0007\u0010\u00bb\u0001\u001a\u00020\u0011J\u0007\u0010\u00bc\u0001\u001a\u00020\u0011J\u0007\u0010\u00bd\u0001\u001a\u00020\u0011J\u0007\u0010\u00be\u0001\u001a\u00020\u0011J\u0007\u0010\u00bf\u0001\u001a\u00020\u0011J\u0007\u0010\u00c0\u0001\u001a\u00020\u0011J\u0007\u0010\u00c1\u0001\u001a\u00020\u0011J\u0007\u0010\u00c2\u0001\u001a\u00020\u0011J\u0007\u0010\u00c3\u0001\u001a\u00020\u0011J\u0007\u0010\u00c4\u0001\u001a\u00020\u0011J\u0007\u0010\u00c5\u0001\u001a\u00020\u0011J\u0007\u0010\u00c6\u0001\u001a\u00020\u0011J\u0007\u0010\u00c7\u0001\u001a\u00020\u0011J\u0007\u0010\u00c8\u0001\u001a\u00020\u0011J\u0007\u0010\u00c9\u0001\u001a\u00020\u0011J\u0007\u0010\u00ca\u0001\u001a\u00020\u0011J\u0007\u0010\u00cb\u0001\u001a\u00020\u0011J\u0007\u0010\u00cc\u0001\u001a\u00020\u0011J\u0007\u0010\u00cd\u0001\u001a\u00020\u0011J\u0007\u0010\u00ce\u0001\u001a\u00020\u0011J\u0007\u0010\u00cf\u0001\u001a\u00020\u0011J\u0007\u0010\u00d0\u0001\u001a\u00020\u0011J\u0007\u0010\u00d1\u0001\u001a\u00020\u0011J\u0007\u0010\u00d2\u0001\u001a\u00020\u0011J\u0007\u0010\u00d3\u0001\u001a\u00020\u0011J\u0007\u0010\u00d4\u0001\u001a\u00020\u0011J\u0007\u0010\u00d5\u0001\u001a\u00020\u0011J\u0007\u0010\u00d6\u0001\u001a\u00020\u0011J\u0007\u0010\u00d7\u0001\u001a\u00020\u0011J\u0007\u0010\u00d8\u0001\u001a\u00020\u0011J\u0007\u0010\u00d9\u0001\u001a\u00020\u0011J\u0007\u0010\u00da\u0001\u001a\u00020\u0011J\u0007\u0010\u00db\u0001\u001a\u00020\u0011J\u0007\u0010\u00dc\u0001\u001a\u00020\u0011J\u0007\u0010\u00dd\u0001\u001a\u00020\u0011J\u0007\u0010\u00de\u0001\u001a\u00020\u0011J\u0007\u0010\u00df\u0001\u001a\u00020\u0011J\u0007\u0010\u00e0\u0001\u001a\u00020\u0011J\u0007\u0010\u00e1\u0001\u001a\u00020\u0011J\u0007\u0010\u00e2\u0001\u001a\u00020\u0011J\u0007\u0010\u00e3\u0001\u001a\u00020\u0011J\u0007\u0010\u00e4\u0001\u001a\u00020\u0011J\u0007\u0010\u00e5\u0001\u001a\u00020\u0011J\u0007\u0010\u00e6\u0001\u001a\u00020\u0011J\u0007\u0010\u00e7\u0001\u001a\u00020\u0011J\u0007\u0010\u00e8\u0001\u001a\u00020\u0011J\u0007\u0010\u00e9\u0001\u001a\u00020\u0011J\u0007\u0010\u00ea\u0001\u001a\u00020\u0011J\u0007\u0010\u00eb\u0001\u001a\u00020\u0011J\u0007\u0010\u00ec\u0001\u001a\u00020\u0011J\u0007\u0010\u00ed\u0001\u001a\u00020\u0011J\u0007\u0010\u00ee\u0001\u001a\u00020\u0011J\u0007\u0010\u00ef\u0001\u001a\u00020\u0011J\u0007\u0010\u00f0\u0001\u001a\u00020\u0011J\u0007\u0010\u00f1\u0001\u001a\u00020\u0011J\u0007\u0010\u00f2\u0001\u001a\u00020\u0011J\u0007\u0010\u00f3\u0001\u001a\u00020\u0011J\u0007\u0010\u00f4\u0001\u001a\u00020\u0011J\u0007\u0010\u00f5\u0001\u001a\u00020\u0011J\u0007\u0010\u00f6\u0001\u001a\u00020\u0011J\u0007\u0010\u00f7\u0001\u001a\u00020\u0011J\u0007\u0010\u00f8\u0001\u001a\u00020\u0011J\u0007\u0010\u00f9\u0001\u001a\u00020\u0011J\u0007\u0010\u00fa\u0001\u001a\u00020\u0011J\u0007\u0010\u00fb\u0001\u001a\u00020\u0011J\u0007\u0010\u00fc\u0001\u001a\u00020\u0011J\u0007\u0010\u00fd\u0001\u001a\u00020\u0011J\u0007\u0010\u00fe\u0001\u001a\u00020\u0011J\u0007\u0010\u00ff\u0001\u001a\u00020\u0011J\u0007\u0010\u0080\u0002\u001a\u00020\u0011J\u0007\u0010\u0081\u0002\u001a\u00020\u0011J\u0007\u0010\u0082\u0002\u001a\u00020\u0011J\u0007\u0010\u0083\u0002\u001a\u00020\u0011J\u0007\u0010\u0084\u0002\u001a\u00020\u0011J\u0007\u0010\u0085\u0002\u001a\u00020\u0011J\u0007\u0010\u0086\u0002\u001a\u00020\u0011J\u0007\u0010\u0087\u0002\u001a\u00020\u0011J\u0007\u0010\u0088\u0002\u001a\u00020\u0011J\u0007\u0010\u0089\u0002\u001a\u00020\u0011J%\u0010\u008a\u0002\u001a\u00030\u008f\u00012\u0007\u0010\u008b\u0002\u001a\u00020\u00042\u0007\u0010\u008c\u0002\u001a\u00020\u00042\u0007\u0010\u008d\u0002\u001a\u00020\u0004H\u0002J\u0007\u0010\u008e\u0002\u001a\u00020\u0011J\u0007\u0010\u008f\u0002\u001a\u00020\u0011J\u0007\u0010\u0090\u0002\u001a\u00020\u0011J\u0007\u0010\u0091\u0002\u001a\u00020\u0011J\u0007\u0010\u0092\u0002\u001a\u00020\u0011J\u0007\u0010\u0093\u0002\u001a\u00020\u0011J\u0007\u0010\u0094\u0002\u001a\u00020\u0011J\u0007\u0010\u0095\u0002\u001a\u00020\u0011J\u0007\u0010\u0096\u0002\u001a\u00020\u0011J\u0007\u0010\u0097\u0002\u001a\u00020\u0011J\u0007\u0010\u0098\u0002\u001a\u00020\u0011J\u0007\u0010\u0099\u0002\u001a\u00020\u0011J\u0007\u0010\u009a\u0002\u001a\u00020\u0011J\u0007\u0010\u009b\u0002\u001a\u00020\u0011J\u0007\u0010\u009c\u0002\u001a\u00020\u0011J\u0007\u0010\u009d\u0002\u001a\u00020\u0011J\u0007\u0010\u009e\u0002\u001a\u00020\u0011J\u0007\u0010\u009f\u0002\u001a\u00020\u0011J\u0007\u0010\u00a0\u0002\u001a\u00020\u0011J\u0007\u0010\u00a1\u0002\u001a\u00020\u0011J\u0007\u0010\u00a2\u0002\u001a\u00020\u0011J\u0007\u0010\u00a3\u0002\u001a\u00020\u0011J\u0007\u0010\u00a4\u0002\u001a\u00020\u0011J\u0007\u0010\u00a5\u0002\u001a\u00020\u0011J\u0007\u0010\u00a6\u0002\u001a\u00020\u0011J\u0007\u0010\u00a7\u0002\u001a\u00020\u0011J\u0007\u0010\u00a8\u0002\u001a\u00020\u0011J\u0007\u0010\u00a9\u0002\u001a\u00020\u0011J\u0007\u0010\u00aa\u0002\u001a\u00020\u0011R\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0003\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u00ab\u0002"}, d2 = {"Lcom/egeozturk/formulaappv04/util/FormulaFunctions;", "", "v", "", "", "nullIndex", "", "constant", "([Ljava/lang/Double;ID)V", "getConstant", "()D", "getNullIndex", "()I", "getV", "()[Ljava/lang/Double;", "[Ljava/lang/Double;", "absoluteRefractiveIndexFormulaFunction", "", "acceleratedMotionFormulaFunction", "accelerationBetweenTwoChargedPlatesFunction", "accelerationFormulaFunction", "angularMomentumFormula2Function", "angularMomentumFormula3Function", "angularMomentumFormulaFunction", "angularMomentumOfAnOrbitingElectronFunction", "angularVelocityFormulaFunction", "areaOfCircleFormulaFunction", "areaOfEquilateralTriangleFormulaFunction", "areaOfParallelogramFormulaFunction", "areaOfRegularHexagonFormulaFunction", "areaOfSquareFormulaFunction", "areaOfTrapezoidFormulaFunction", "areaOfTriangleFormulaFunction", "atomicMassFormulaFunction", "averageKineticEnergyFormulaOfGasMoleculesFunction", "averageRateOfChangeFormulaFunction", "averageVelocityOfGasMoleculesFormulaFunction", "avogadrosLawFunction", "binomialExpansionsFunction", "boilingPointElevationFormulaFunction", "boylesLawFunction", "buoyantForceFormulaFunction", "capacitanceFormulaFunction", "capacitanceOfCapacitorFormulaFunction", "centralElasticCollisionVelocitiesEquationFunction", "centripetalAccelerationFormula2Function", "centripetalAccelerationFormulaFunction", "centripetalForceFormula2Function", "centripetalForceFormulaFunction", "changeOfConcentrationEquationFunction", "charlessLawFunction", "circumferenceOfCircleFormulaFunction", "combinationFunction", "coordinatesOfTheCentroidOfATriangleFormulaFunction", "coordinatesOfTheMidpointOfALineSegmentFormulaFunction", "coulombsLawFunction", "cyclicPermutationFormula", "diffusionRateEquationFunction", "distanceBetweenTwoPointsOnTheAnalyticalPlaneFormulaFunction", "doubleAngleFormulaForCosineFunction", "doubleAngleFormulaForSineFunction", "doubleAngleFormulaForTangentFunction", "downwardProjectileMotionHeightFormulaFunction", "downwardProjectileMotionVelocityFormulaFunction", "efficiencyFormulaFunction", "elasticPotentialEnergyFunction", "electricCurrentFormulaFunction", "electricEnergyFormulaFunction", "electricFieldBetweenTwoChargedPlatesFunction", "electricFieldFormula2Function", "electricFieldFormulaFunction", "electricPotentialEnergyFunction", "electricPotentialFormulaFunction", "electricPowerFormula2Function", "electricPowerFormulaFunction", "electromagneticInductionFormulaFunction", "energyOfElectronInBohrOrbitFunction", "energyStoredInCapacitor2Function", "energyStoredInCapacitorFunction", "enthalpyFormula2Function", "enthalpyFormulaFunction", "escapeEnergyFormulaFunction", "escapeVelocityFormulaFunction", "exponentialFunctionFormulaFunction", "exteriorAngleOfRegularPolygonFunction", "factorial", "n", "factorialFormulaFunction", "factorisationOfDifferenceOfTwoCubes", "factorisationOfDifferenceOfTwoSquares", "factorisationOfDifferenceOfXnAndYnFunction", "factorisationOfSumOfTwoCubesFunction", "factorisationOfSumOfXnAndYnFunction", "fahrenheitCelsiusConverterFunction", "fibonacciSequenceStartingFrom1TermFinderFunction", "findPositiveIntegerDivisor", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "number", "findPrimeNumberUntil", "", "limit", "forceBetweenTwoChargedPlatesFunction", "forceFormulaFunction", "freeFallHeightFormulaFunction", "freeFallVelocityFormulaWithoutTimeFunction", "freeFallVerticalVelocityFormulaFunction", "freezingPointDepressionFormulaFunction", "frictionForceFormulaFunction", "fringeSpacingFormulaDoubleSlitFunction", "fringeSpacingFormulaSingleSlitFunction", "gayLussacsLawFunction", "gcd", "num1", "num2", "grahamsLawOfDiffusionFunction", "gravitationalAccelerationFormulaAboveSurfaceFunction", "gravitationalAccelerationFormulaInsidePlanetFunction", "gravitationalForceFormulaFunction", "gravitationalPotentialEnergyFunction", "gravitationalPotentialEnergyOfAnOrbitingSatelliteFunction", "greatestCommonDivisorFunction", "heatConductionRateFormulaFunction", "heatFormulaFunction", "heatOfTransformationFormulaFunction", "heightOfRegularTetrahedronFormulaFunction", "heronsFormulaFunction", "hookesLawFunction", "horizontalAccelerationDuringSimpleHarmonicMotion2Function", "horizontalAccelerationDuringSimpleHarmonicMotionFunction", "horizontalLocationDuringSimpleHarmonicMotion2Function", "horizontalLocationDuringSimpleHarmonicMotionFunction", "horizontalRestoringForceDuringSimpleHarmonicMotion2Function", "horizontalRestoringForceDuringSimpleHarmonicMotionFunction", "horizontalVelocityDuringSimpleHarmonicMotion2Function", "horizontalVelocityDuringSimpleHarmonicMotionFunction", "idealGasLaw2Function", "idealGasLawFunction", "illuminanceFormula2Function", "illuminanceFormulaFunction", "impulseFormulaFunction", "interiorAngleOfRegularPolygonFunction", "isPrime", "", "kineticEnergyFormulaFunction", "kineticEnergyOfARotatingObjectFunction", "kineticEnergyOfGasFormulaFunction", "lawOfCosinesFunction", "lawOfPeriodsFunction", "lawOfSinesFunction", "lcm", "leastCommonMultipleFunction", "lengthOfSpaceDiagonalInRectangularPrismFormulaFunction", "linearExpansionFormulaFunction", "linearVelocityFormula2Function", "linearVelocityFormulaFunction", "logarithmFormulaFunction", "lorentzForceFormulaFunction", "luminousFluxFormulaFunction", "magneticFieldOfCurrentLoopsFunction", "magneticFieldOfSolenoidsFunction", "magneticFieldOfStraightWiresFunction", "magneticFluxFormulaFunction", "magneticForceOfCurrentCarryingWiresFunction", "massOfProducedSubstanceDuringElectrolysisFormulaFunction", "massPercentCompositionFormulaFunction", "maximumSafeSpeedAnObjectCanTakeOnAFrictionalTurnFunction", "minVeloOfAnObjectRotatingInACylinderFunction", "molalityFormulaFunction", "molarityFormula2Function", "molarityFormulaFunction", "momentOfInertiaFormulaFunction", "momentOfInertiaOfDisksFunction", "momentOfInertiaOfRingsFunction", "momentOfInertiaOfRodsFunction", "momentOfInertiaOfSolidCylindersFunction", "momentOfInertiaOfSolidSpheresFunction", "momentumFormulaFunction", "naturalLogarithmFormulaFunction", "nernstEquationFunction", "nthPowerOfiCalculatorFunction", "nthTermOfAGeometricSequenceFormulaFunction", "numberOfDiagonalsFormulaFunction", "numberOfImagesFormulaIntersectingMirrorsFunction", "numberOfMolesFormula2Function", "numberOfMolesFormulaForGasesUnderNormalConditionsFunction", "numberOfMolesFormulaFunction", "numberOfProperSubsetFormulaFunction", "numberOfSubsetFormulaFunction", "ohmsLawFunction", "orbitingRadiusOfAnElectronFunction", "partialPressureFormulaFunction", "peakElectromotiveForceInAGeneratorFunction", "periodOfSimplePendulumDuringSimpleHarmonicMotionFunction", "periodOfSpringPendulumDuringSimpleHarmonicMotionFunction", "permutationFunction", "positiveIntegerDivisorFinder", "powerFormulaFunction", "ppbFormulaFunction", "ppmFormulaFunction", "pressureOfLiquidsFunction", "pressureOfSolidsFunction", "primeFactorFinderFunction", "primeNumberCheckerFunction", "principalAngleFinderFunction", "productOfTheMembersOfAGeometricSequenceFormulaFunction", "pythagoreanTheoremFunction", "radianDegreeConverterFunction", "radiusOfOrbitOfAChargeInMagneticFieldFunction", "reactionRateFormula2Function", "reactionRateFormulaFunction", "rectangleAreaFormulaFunction", "reflectionAcrossXAFormulaFunction", "reflectionAcrossXAxisFormulaFunction", "reflectionAcrossYAFormulaFunction", "reflectionAcrossYAxisFormulaFunction", "reflectionAcrossYXFormulaFunction", "reflectionAcrossYminusXFormulaFunction", "reflectionOfALineAcrossXAxisFormulaFunction", "reflectionOfALineAcrossXDFormulaFunction", "reflectionOfALineAcrossYAxisFormulaFunction", "reflectionOfALineAcrossYEFormulaFunction", "reflectionOfALineAcrossYXFormulaFunction", "reflectionOfALineAcrossYminusXFormulaFunction", "reflectionOfALineOverOriginFormulaFunction", "reflectionOverOriginFormulaFunction", "relationshipBetweenEquilibriumConstantsFunction", "relativeMotionFormulaFunction", "resistanceOfConductorFunction", "rootCalculatorFunction", "rootMeanSquareCurrentFormulaSinusoidalWaveformFunction", "rootMeanSquareCurrentFormulaSquareWaveformFunction", "rootMeanSquareCurrentFormulaTriangleWaveformFunction", "rootMeanSquareVoltageFormulaSinusoidalWaveformFunction", "rootMeanSquareVoltageFormulaSquareWaveformFunction", "rootMeanSquareVoltageFormulaTriangleWaveformFunction", "rootsOfQuadraticEquationFunction", "rotationOfAPointAroundOriginFormulaFunction", "rotationalKineticEnergyFormulaFunction", "rthTermOfAnArithmeticSequenceFormulaFunction", "safeSpeedDuringTurningInACylinderFunction", "safeSpeedDuringTurningOnAnInclinedAndFrictionlessTurnFunction", "screwEquationFunction", "secondDegreeBinomialExpansionFunction", "secondDegreeTrinomialExpansionFunction", "selfInductionEmfFormulaFunction", "sumFormulaForCosineFunction", "sumFormulaForSineFunction", "sumFormulaForTangentFunction", "sumOfInteriorAnglesOfPolygonsFormulaFunction", "sumOfTheMembersOfAGeometricSequenceFormulaFunction", "sumOfTheMembersOfAnArithmeticSequenceFormulaFunction", "superficialExpansionFormulaFunction", "surfaceAreaOfConeFormulaFunction", "surfaceAreaOfCubeFormulaFunction", "surfaceAreaOfCylinderFormulaFunction", "surfaceAreaOfRectangularPrismFormulaFunction", "surfaceAreaOfRegularTetrahedronFormulaFunction", "surfaceAreaOfSphereFormulaFunction", "tangentialAccelerationFormulaFunction", "thirdDegreeBinomialExpansionFunction", "torqueFormula2Function", "torqueFormulaFunction", "torqueOfACurrentCarryingLoopInMagneticFieldFunction", "totalWorkDoneFormulaFunction", "transformerEquationFunction", "triangleCheck", "a", "b", "c", "triangleInequalityCalculatorFunction", "upwardProjectileMotionFlightTimeFormulaFunction", "upwardProjectileMotionHeightFormulaFunction", "upwardProjectileMotionMaximumHeightFormulaFunction", "upwardProjectileMotionVelocityFormulaFunction", "velocityDuringSimpleHarmonicMotionFunction", "velocityFormulaFunction", "velocityFormulaWithoutTimeFunction", "velocityOfGasParticlesFormulaFunction", "velocityOfWavesFormulaFunction", "verticalAccelerationDuringSimpleHarmonicMotion2Function", "verticalAccelerationDuringSimpleHarmonicMotionFunction", "verticalLocationDuringSimpleHarmonicMotion2Function", "verticalLocationDuringSimpleHarmonicMotionFunction", "verticalRestoringForceDuringSimpleHarmonicMotion2Function", "verticalRestoringForceDuringSimpleHarmonicMotionFunction", "verticalVelocityDuringSimpleHarmonicMotion2Function", "verticalVelocityDuringSimpleHarmonicMotionFunction", "volumeOfConeFormulaFunction", "volumeOfCubeFormulaFunction", "volumeOfCylinderFormulaFunction", "volumeOfPyramidFormulaFunction", "volumeOfRectangularPrismFormulaFunction", "volumeOfRegularTetrahedronFormulaFunction", "volumeOfSphereFormulaFunction", "volumePercentCompositionFormulaFunction", "volumetricExpansionFormulaFunction", "weightFormulaFunction", "workFormulaFunction", "app_debug"})
public final class FormulaFunctions {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Double[] v = null;
    private final int nullIndex = 0;
    private final double constant = 0.0;
    
    public FormulaFunctions(@org.jetbrains.annotations.NotNull()
    java.lang.Double[] v, int nullIndex, double constant) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Double[] getV() {
        return null;
    }
    
    public final int getNullIndex() {
        return 0;
    }
    
    public final double getConstant() {
        return 0.0;
    }
    
    private final boolean triangleCheck(double a, double b, double c) {
        return false;
    }
    
    private final double factorial(double n) {
        return 0.0;
    }
    
    private final java.util.ArrayList<java.lang.Long> findPrimeNumberUntil(long limit) {
        return null;
    }
    
    private final boolean isPrime(double number) {
        return false;
    }
    
    private final java.util.ArrayList<java.lang.Integer> findPositiveIntegerDivisor(double number) {
        return null;
    }
    
    private final long gcd(double num1, double num2) {
        return 0L;
    }
    
    private final long lcm(double num1, double num2) {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String pythagoreanTheoremFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String rectangleAreaFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String circumferenceOfCircleFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String areaOfCircleFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String surfaceAreaOfSphereFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String volumeOfSphereFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String sumOfInteriorAnglesOfPolygonsFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String numberOfDiagonalsFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String rootsOfQuadraticEquationFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String volumeOfRectangularPrismFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String volumeOfCylinderFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String areaOfTriangleFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String heronsFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String permutationFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String combinationFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String volumeOfPyramidFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String volumeOfConeFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String surfaceAreaOfConeFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String surfaceAreaOfRectangularPrismFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String lawOfCosinesFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String lawOfSinesFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String doubleAngleFormulaForSineFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String sumFormulaForSineFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String doubleAngleFormulaForCosineFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String sumFormulaForCosineFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String doubleAngleFormulaForTangentFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String sumFormulaForTangentFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String areaOfRegularHexagonFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String numberOfSubsetFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String numberOfProperSubsetFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String primeFactorFinderFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String primeNumberCheckerFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String positiveIntegerDivisorFinder() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String greatestCommonDivisorFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String leastCommonMultipleFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String rootCalculatorFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String triangleInequalityCalculatorFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String areaOfEquilateralTriangleFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String factorialFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String cyclicPermutationFormula() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String secondDegreeBinomialExpansionFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String thirdDegreeBinomialExpansionFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String secondDegreeTrinomialExpansionFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String factorisationOfDifferenceOfTwoSquares() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String factorisationOfDifferenceOfTwoCubes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String factorisationOfSumOfTwoCubesFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String factorisationOfSumOfXnAndYnFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String factorisationOfDifferenceOfXnAndYnFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String binomialExpansionsFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String interiorAngleOfRegularPolygonFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String exteriorAngleOfRegularPolygonFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String areaOfTrapezoidFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String areaOfParallelogramFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String areaOfSquareFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String lengthOfSpaceDiagonalInRectangularPrismFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String volumeOfCubeFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String surfaceAreaOfCubeFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String surfaceAreaOfCylinderFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String heightOfRegularTetrahedronFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String surfaceAreaOfRegularTetrahedronFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String volumeOfRegularTetrahedronFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String radianDegreeConverterFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String principalAngleFinderFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String distanceBetweenTwoPointsOnTheAnalyticalPlaneFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String coordinatesOfTheMidpointOfALineSegmentFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String coordinatesOfTheCentroidOfATriangleFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String averageRateOfChangeFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String exponentialFunctionFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String logarithmFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String naturalLogarithmFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String rthTermOfAnArithmeticSequenceFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String sumOfTheMembersOfAnArithmeticSequenceFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String nthTermOfAGeometricSequenceFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String sumOfTheMembersOfAGeometricSequenceFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String productOfTheMembersOfAGeometricSequenceFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String fibonacciSequenceStartingFrom1TermFinderFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String nthPowerOfiCalculatorFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String rotationOfAPointAroundOriginFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String reflectionAcrossXAxisFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String reflectionAcrossYAxisFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String reflectionAcrossYXFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String reflectionAcrossYminusXFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String reflectionAcrossXAFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String reflectionAcrossYAFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String reflectionOverOriginFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String reflectionOfALineAcrossXAxisFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String reflectionOfALineAcrossYAxisFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String reflectionOfALineAcrossYXFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String reflectionOfALineAcrossYminusXFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String reflectionOfALineAcrossXDFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String reflectionOfALineAcrossYEFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String reflectionOfALineOverOriginFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String idealGasLawFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String kineticEnergyOfGasFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String velocityOfGasParticlesFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String idealGasLaw2Function() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String boylesLawFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String charlessLawFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String gayLussacsLawFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String avogadrosLawFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String numberOfMolesFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String numberOfMolesFormula2Function() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String atomicMassFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String numberOfMolesFormulaForGasesUnderNormalConditionsFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String massPercentCompositionFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String volumePercentCompositionFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String ppmFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String ppbFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String averageKineticEnergyFormulaOfGasMoleculesFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String grahamsLawOfDiffusionFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String averageVelocityOfGasMoleculesFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String diffusionRateEquationFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String partialPressureFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String molarityFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String molalityFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String changeOfConcentrationEquationFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String molarityFormula2Function() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String boilingPointElevationFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String freezingPointDepressionFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String enthalpyFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String enthalpyFormula2Function() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String reactionRateFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String reactionRateFormula2Function() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String relationshipBetweenEquilibriumConstantsFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String nernstEquationFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String massOfProducedSubstanceDuringElectrolysisFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String kineticEnergyFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String gravitationalPotentialEnergyFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String elasticPotentialEnergyFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String forceFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String workFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String powerFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String ohmsLawFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String electricPowerFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String electricCurrentFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String electricFieldFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String coulombsLawFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String electricPotentialEnergyFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String electricFieldFormula2Function() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String capacitanceFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String pressureOfSolidsFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String pressureOfLiquidsFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String electricPowerFormula2Function() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String resistanceOfConductorFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String electricPotentialFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String electricFieldBetweenTwoChargedPlatesFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String forceBetweenTwoChargedPlatesFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String accelerationBetweenTwoChargedPlatesFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String transformerEquationFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String magneticFieldOfStraightWiresFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String magneticFieldOfCurrentLoopsFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String magneticFieldOfSolenoidsFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String magneticForceOfCurrentCarryingWiresFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String lorentzForceFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String radiusOfOrbitOfAChargeInMagneticFieldFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String magneticFluxFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String electromagneticInductionFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String selfInductionEmfFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String peakElectromotiveForceInAGeneratorFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String relativeMotionFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String velocityFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String accelerationFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String acceleratedMotionFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String heatFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String heatOfTransformationFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String hookesLawFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String linearVelocityFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String linearVelocityFormula2Function() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String angularVelocityFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String centripetalForceFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String centripetalForceFormula2Function() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String centripetalAccelerationFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String centripetalAccelerationFormula2Function() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String minVeloOfAnObjectRotatingInACylinderFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String velocityOfWavesFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String luminousFluxFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String illuminanceFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String velocityDuringSimpleHarmonicMotionFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String horizontalVelocityDuringSimpleHarmonicMotionFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String verticalVelocityDuringSimpleHarmonicMotionFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String horizontalVelocityDuringSimpleHarmonicMotion2Function() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String verticalVelocityDuringSimpleHarmonicMotion2Function() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String horizontalLocationDuringSimpleHarmonicMotionFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String verticalLocationDuringSimpleHarmonicMotionFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String horizontalLocationDuringSimpleHarmonicMotion2Function() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String verticalLocationDuringSimpleHarmonicMotion2Function() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String horizontalAccelerationDuringSimpleHarmonicMotionFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String verticalAccelerationDuringSimpleHarmonicMotionFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String horizontalAccelerationDuringSimpleHarmonicMotion2Function() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String verticalAccelerationDuringSimpleHarmonicMotion2Function() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String horizontalRestoringForceDuringSimpleHarmonicMotionFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String verticalRestoringForceDuringSimpleHarmonicMotionFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String horizontalRestoringForceDuringSimpleHarmonicMotion2Function() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String verticalRestoringForceDuringSimpleHarmonicMotion2Function() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String periodOfSpringPendulumDuringSimpleHarmonicMotionFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String periodOfSimplePendulumDuringSimpleHarmonicMotionFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String maximumSafeSpeedAnObjectCanTakeOnAFrictionalTurnFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String safeSpeedDuringTurningOnAnInclinedAndFrictionlessTurnFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String safeSpeedDuringTurningInACylinderFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String momentOfInertiaFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String momentOfInertiaOfSolidSpheresFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String momentOfInertiaOfSolidCylindersFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String momentOfInertiaOfDisksFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String momentOfInertiaOfRingsFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String momentOfInertiaOfRodsFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String rotationalKineticEnergyFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String kineticEnergyOfARotatingObjectFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String angularMomentumFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String angularMomentumFormula2Function() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String angularMomentumFormula3Function() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String torqueFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String torqueFormula2Function() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String tangentialAccelerationFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String gravitationalForceFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String gravitationalAccelerationFormulaAboveSurfaceFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String gravitationalAccelerationFormulaInsidePlanetFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String gravitationalPotentialEnergyOfAnOrbitingSatelliteFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String escapeVelocityFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String escapeEnergyFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String lawOfPeriodsFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String fringeSpacingFormulaDoubleSlitFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String fringeSpacingFormulaSingleSlitFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String angularMomentumOfAnOrbitingElectronFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String orbitingRadiusOfAnElectronFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String energyOfElectronInBohrOrbitFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String energyStoredInCapacitorFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String energyStoredInCapacitor2Function() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String capacitanceOfCapacitorFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String torqueOfACurrentCarryingLoopInMagneticFieldFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String rootMeanSquareVoltageFormulaSinusoidalWaveformFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String rootMeanSquareVoltageFormulaTriangleWaveformFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String rootMeanSquareVoltageFormulaSquareWaveformFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String rootMeanSquareCurrentFormulaSinusoidalWaveformFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String rootMeanSquareCurrentFormulaTriangleWaveformFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String rootMeanSquareCurrentFormulaSquareWaveformFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String efficiencyFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String weightFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String frictionForceFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String velocityFormulaWithoutTimeFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String downwardProjectileMotionHeightFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String upwardProjectileMotionHeightFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String downwardProjectileMotionVelocityFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String upwardProjectileMotionVelocityFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String upwardProjectileMotionFlightTimeFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String upwardProjectileMotionMaximumHeightFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String freeFallHeightFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String freeFallVerticalVelocityFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String freeFallVelocityFormulaWithoutTimeFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String impulseFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String momentumFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String centralElasticCollisionVelocitiesEquationFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String screwEquationFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String illuminanceFormula2Function() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String numberOfImagesFormulaIntersectingMirrorsFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String absoluteRefractiveIndexFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String buoyantForceFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String electricEnergyFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String totalWorkDoneFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String fahrenheitCelsiusConverterFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String heatConductionRateFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String linearExpansionFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String superficialExpansionFormulaFunction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String volumetricExpansionFormulaFunction() {
        return null;
    }
}