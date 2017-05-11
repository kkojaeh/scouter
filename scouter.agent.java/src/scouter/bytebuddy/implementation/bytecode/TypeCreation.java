// Generated by delombok at Sun Feb 26 12:31:38 KST 2017
package scouter.bytebuddy.implementation.bytecode;

import scouter.bytebuddy.description.type.TypeDescription;
import scouter.bytebuddy.implementation.Implementation;
import scouter.bytebuddy.jar.asm.MethodVisitor;
import scouter.bytebuddy.jar.asm.Opcodes;

/**
 * A stack manipulation for creating an <i>undefined</i> type on which a constructor is to be called.
 */
public class TypeCreation implements StackManipulation {
    /**
     * The type that is being created.
     */
    private final TypeDescription typeDescription;

    /**
     * Constructs a new type creation.
     *
     * @param typeDescription The type to be create.
     */
    protected TypeCreation(TypeDescription typeDescription) {
        this.typeDescription = typeDescription;
    }

    /**
     * Creates a type creation for the given type.
     *
     * @param typeDescription The type to be create.
     * @return A stack manipulation that represents the creation of the given type.
     */
    public static StackManipulation of(TypeDescription typeDescription) {
        if (typeDescription.isArray() || typeDescription.isPrimitive() || typeDescription.isAbstract()) {
            throw new IllegalArgumentException(typeDescription + " is not instantiable");
        }
        return new TypeCreation(typeDescription);
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
        methodVisitor.visitTypeInsn(Opcodes.NEW, typeDescription.getInternalName());
        return new Size(1, 1);
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof TypeCreation)) return false;
        final TypeCreation other = (TypeCreation) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$typeDescription = this.typeDescription;
        final java.lang.Object other$typeDescription = other.typeDescription;
        if (this$typeDescription == null ? other$typeDescription != null : !this$typeDescription.equals(other$typeDescription)) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof TypeCreation;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $typeDescription = this.typeDescription;
        result = result * PRIME + ($typeDescription == null ? 43 : $typeDescription.hashCode());
        return result;
    }
}