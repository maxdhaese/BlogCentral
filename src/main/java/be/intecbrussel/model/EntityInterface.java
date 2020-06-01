package be.intecbrussel.model;

public interface EntityInterface {
    Object getId();

    void cloneFrom(EntityInterface object);
}
