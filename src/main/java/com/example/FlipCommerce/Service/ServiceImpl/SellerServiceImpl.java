package com.example.FlipCommerce.Service.ServiceImpl;

import com.example.FlipCommerce.DTO.RequestDto.SellerRequestDto;
import com.example.FlipCommerce.DTO.ResponseDto.SellerResponseDto;
import com.example.FlipCommerce.Model.Seller;
import com.example.FlipCommerce.Repository.SellerRepository;
import com.example.FlipCommerce.Service.SellerService;
import com.example.FlipCommerce.Transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    SellerRepository sellerRepository;
    @Override
    public SellerResponseDto addSeller(SellerRequestDto sellerRequestDto) {
        Seller seller= SellerTransformer.sellerRequestDtotoSeller(sellerRequestDto);
        Seller savedSeller=sellerRepository.save(seller);
        return SellerTransformer.sellerToSellerResponseDto(savedSeller);
    }
}
