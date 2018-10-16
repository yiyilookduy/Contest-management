package duypn.classes.converters;

import duypn.dtos.ContestDTO;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class StringConverter {

    public static String convert(String stringConvert, Charset oldType, Charset newType){
        return new String(stringConvert.getBytes(oldType), newType);
    }

    /**
     *  Default convert from ISO-8859-1 to UTF8
     * @param stringConvert convert string
     * @return converted string
     */
    public static String convert(String stringConvert){
        return new String(stringConvert.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    }

    public static ContestDTO convert(ContestDTO contest){
        String description = convert(contest.getDescription());
        String name = convert(contest.getContestName());
        String address = convert(contest.getAddress());
        contest.setDescription(description);
        contest.setContestName(name);
        contest.setAddress(address);
        return contest;
    }
}



