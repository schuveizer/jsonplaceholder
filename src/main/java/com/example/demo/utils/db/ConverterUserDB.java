package com.example.demo.utils.db;

import com.example.demo.model.domain.user.UserAddressDomain;
import com.example.demo.model.domain.user.UserAddressGeoDomain;
import com.example.demo.model.domain.user.UserCompanyDomain;
import com.example.demo.model.domain.user.UserDomain;
import com.example.demo.model.dto.user.UserAddressDTO;
import com.example.demo.model.dto.user.UserAddressGeoDTO;
import com.example.demo.model.dto.user.UserCompanyDTO;
import com.example.demo.model.request.UserRequest;
import com.example.demo.model.response.UserResponse;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component

public class ConverterUserDB {

    public static UserDomain convertUserRequestToDomain (UserRequest user){
        return UserDomain.builder()
                .name(user.getName())
                .username(user.getUsername())
                .email(user.getEmail())
                .address(Objects.isNull(user.getAddress()) ? null : convertUserAddressDTOToDomain(user.getAddress()))
                .phone(user.getPhone())
                .website(user.getWebsite())
                .company(Objects.isNull(user.getCompany()) ? null : convertUserCompanyDTOToDomain((user.getCompany())))
                .build();
    }

    private static UserAddressDomain convertUserAddressDTOToDomain (UserAddressDTO address){
        return UserAddressDomain.builder()
                .street(address.getStreet())
                .suite(address.getSuite())
                .city(address.getCity())
                .zipcode(address.getZipcode())
                .geo(Objects.isNull(address.getGeo()) ? null : UserAddressGeoDomain.builder()
                        .lat(address.getGeo().getLat())
                        .lng(address.getGeo().getLng())
                        .build())
                .build();
    }

    private static UserCompanyDomain convertUserCompanyDTOToDomain (UserCompanyDTO company){
        return UserCompanyDomain.builder()
                .name(company.getName())
                .catchPhrase(company.getCatchPhrase())
                .bs(company.getBs())
                .build();
    }

    public static UserResponse convertUserDomainToResponse (UserDomain user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .email(user.getEmail())
                .address(Objects.isNull(user.getAddress()) ? null : convertUserAddressDomainToDTO(user.getAddress()))
                .phone(user.getPhone())
                .website(user.getWebsite())
                .company(Objects.isNull(user.getCompany()) ? null : convertUserCompanyDomainToDTO((user.getCompany())))
                .build();
    }

    private static UserAddressDTO convertUserAddressDomainToDTO (UserAddressDomain address){
        return UserAddressDTO.builder()
                .street(address.getStreet())
                .suite(address.getSuite())
                .city(address.getCity())
                .zipcode(address.getZipcode())
                .geo(Objects.isNull(address.getGeo()) ? null : UserAddressGeoDTO.builder()
                        .lat(address.getGeo().getLat())
                        .lng(address.getGeo().getLng())
                        .build())
                .build();
    }

    private static UserCompanyDTO convertUserCompanyDomainToDTO (UserCompanyDomain company){
        return UserCompanyDTO.builder()
                .name(company.getName())
                .catchPhrase(company.getCatchPhrase())
                .bs(company.getBs())
                .build();
    }
}
