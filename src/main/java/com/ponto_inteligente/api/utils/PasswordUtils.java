package com.ponto_inteligente.api.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {
    private static final Logger Log= LoggerFactory.getLogger(PasswordUtils.class);

    public PasswordUtils() {

    }

    /** Gera um hash utilizando o bCrypt
     * @param senha
     * @return String
     */

   public static String gerarBCypt(String senha) {
       if (senha == null) {
           return senha;
       }
       Log.info ("Gerando hash com BCrypt");
       BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder ();
       return bCryptEncoder.encode (senha);
   }

}
