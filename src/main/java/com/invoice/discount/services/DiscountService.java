package com.invoice.discount.services;

import com.invoice.discount.DiscountDTO;
import com.invoice.discount.DiscountExternalAPI;
import com.invoice.discount.exceptions.DiscountNotFoundException;
import com.invoice.discount.mappers.DiscountMapper;
import com.invoice.discount.models.Discount;
import com.invoice.discount.repositories.DiscountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DiscountService implements DiscountExternalAPI {
    private DiscountRepository discountRepository;
    private DiscountMapper discountMapper;

    @Override
    public DiscountDTO getDiscountById(Long id) {
        return discountMapper.discountToDiscountDTO(
                discountRepository.findById(id)
                        .orElseThrow(DiscountNotFoundException::new)
        );
    }

    @Override
    public List<DiscountDTO> getAllDiscounts() {
        return discountRepository.findAll()
                .stream()
                .map(discount -> discountMapper.discountToDiscountDTO(discount))
                .toList();
    }
    @Transactional // Asegura que la operación de guardado está envuelta en una transacción
    @Override
    public DiscountDTO saveDiscount(DiscountDTO discountDTO) {
        return discountMapper.discountToDiscountDTO(
                discountRepository.save(discountMapper.discountDTOToDiscount(discountDTO)));
    }

    @Transactional
    @Override
    public DiscountDTO updateDiscount(Long id, DiscountDTO discountDTO) {
        Discount discount = discountMapper.discountDTOToDiscount(getDiscountById(id));
        discount.setName(discountDTO.name());
        discount.setDescription(discountDTO.description());
        discount.setPercentage(discountDTO.percentage());

        return discountMapper.discountToDiscountDTO(discountRepository.save(discount));

    }

    @Transactional
    @Override
    public DiscountDTO deleteDiscount(Long id) {
        Discount discount = discountMapper.discountDTOToDiscount(getDiscountById(id));
        DiscountDTO discountDTO = discountMapper.discountToDiscountDTO(discount);
        discountRepository.delete(discount);
        return discountDTO;
    }
}
