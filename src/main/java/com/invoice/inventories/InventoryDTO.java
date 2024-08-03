package com.invoice.inventories;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.invoice.inventories.validations.anotations.ValidDescriptionInventory;
import jakarta.validation.constraints.Digits;

import java.time.ZonedDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record InventoryDTO(
        Long id,

        Long userId,

        Long productId,

        Long sucursalId,

        Long reasonId,

        @Digits(message="${custom.adjust-validation-inventory.message}", fraction = 0, integer = 10) Integer adjust,

        @ValidDescriptionInventory String description) {

}