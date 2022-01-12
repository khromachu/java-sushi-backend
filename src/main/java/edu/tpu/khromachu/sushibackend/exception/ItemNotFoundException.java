package edu.tpu.khromachu.sushibackend.exception;

public class ItemNotFoundException extends Exception {
    private Integer id;

    public ItemNotFoundException(Integer id) {
        super(String.format("Item is not found with id : '%s'", id));
    }
}