package com.example.demo.utils.db.unit;

import com.example.demo.model.domain.unit.AlbumDomain;
import com.example.demo.model.domain.unit.user.UserAddressDomain;
import com.example.demo.model.domain.unit.user.UserAddressGeoDomain;
import com.example.demo.model.domain.unit.user.UserCompanyDomain;
import com.example.demo.model.domain.unit.user.UserDomain;
import com.example.demo.model.dto.unit.user.UserAddressDTO;
import com.example.demo.model.dto.unit.user.UserAddressGeoDTO;
import com.example.demo.model.dto.unit.user.UserCompanyDTO;
import com.example.demo.model.gateway.AlbumGateway;
import com.example.demo.model.gateway.user.UserAddressGateway;
import com.example.demo.model.gateway.user.UserCompanyGateway;
import com.example.demo.model.gateway.user.UserGateway;
import com.example.demo.model.request.unit.UserRequest;
import com.example.demo.model.response.unit.UserResponse;
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
                .id(user.getId().toHexString())
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

    public static UserDomain convertUserGatewayToDomain (UserGateway user){
        return UserDomain.builder()
                .name(user.getName())
                .username(user.getUsername())
                .email(user.getEmail())
                .address(convertUserAddressGatewayToDomain(user.getAddress()))
                .phone(user.getPhone())
                .website(user.getWebsite())
                .company(convertUserCompanyGatewayToDomain(user.getCompany()))
                .build();
    }

    public static UserAddressDomain convertUserAddressGatewayToDomain(UserAddressGateway address) {
        return UserAddressDomain.builder()
                .street(address.getStreet())
                .suite(address.getSuite())
                .city(address.getCity())
                .zipcode(address.getZipcode())
                .geo(UserAddressGeoDomain.builder()
                        .lat(Double.parseDouble(address.getGeo().getLat()))
                        .lng(Double.parseDouble(address.getGeo().getLng()))
                        .build())
                .build();
    }

    public static UserCompanyDomain convertUserCompanyGatewayToDomain(UserCompanyGateway company) {
        return UserCompanyDomain.builder()
                .name(company.getName())
                .catchPhrase(company.getCatchPhrase())
                .bs(company.getBs())
                .build();
    }

}
