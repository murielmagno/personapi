package br.com.murielmagno.personapi.utils;

import br.com.murielmagno.personapi.dto.request.PhoneDTO;
import br.com.murielmagno.personapi.entity.Phone;
import br.com.murielmagno.personapi.enums.PhoneType;

public class PhoneUtils {

    private static final String PHONE_NUMBER = "1199999-9999";
    private static final PhoneType PHONE_TYPE = PhoneType.CELULAR;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .numero(PHONE_NUMBER)
                .tipo(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .numero(PHONE_NUMBER)
                .tipo(PHONE_TYPE)
                .build();
    }
}