package com.example.oliviamurphy.MakeMePretty;

/**
 * Created by oliviamurphy on 4/14/16.
 */
public class Question {
    private int ID;
    private String QUESTION;
    private String OPTA;
    private String OPTB;
    private String OPTC;
    private String OPTD;
    private String ANSWERA;
    private String ANSWERB;
    private String ANSWERC;
    private String ANSWERD;

    public Question() {
        ID = 0;
        QUESTION = "";
        OPTA = "";
        OPTB = "";
        OPTC = "";
        OPTD = "";
        ANSWERA = "";
        ANSWERB = "";
        ANSWERC = "";
        ANSWERD = "";
    }

    public Question(String qUESTION, String oPTA, String oPTB, String oPTC, String oPTD,
                    String aNSWERA, String aNSWERB, String aNSWERC, String aNSWERD) {

        QUESTION = qUESTION;
        OPTA = oPTA;
        OPTB = oPTB;
        OPTC = oPTC;
        OPTD = oPTD;
        ANSWERA = aNSWERA;
        ANSWERB = aNSWERB;
        ANSWERC = aNSWERC;
        ANSWERD = aNSWERD;
    }
    public int getID()
    {
        return ID;
    }
    public String getQUESTION() {
        return QUESTION;
    }
    public String getOPTA() {
        return OPTA;
    }
    public String getOPTB() {
        return OPTB;
    }
    public String getOPTC() {
        return OPTC;
    }
    public String getOPTD() {
        return OPTD;
    }
    public String getANSWERA() {
        return ANSWERA;
    }
    public String getANSWERB() {
        return ANSWERB;
    }
    public String getANSWERC() {
        return ANSWERC;
    }
    public String getANSWERD() {
        return ANSWERD;
    }
    public void setID(int id)
    {
        ID=id;
    }
    public void setQUESTION(String qUESTION) {
        QUESTION = qUESTION;
    }
    public void setOPTA(String oPTA) {
        OPTA = oPTA;
    }
    public void setOPTB(String oPTB) {
        OPTB = oPTB;
    }
    public void setOPTC(String oPTC) {
        OPTC = oPTC;
    }
    public void setOPTD(String oPTD) {
        OPTD = oPTD;
    }
    public void setANSWERA(String aNSWERA) {
        ANSWERA = aNSWERA;
    }
    public void setANSWERB(String aNSWERB) {
        ANSWERB = aNSWERB;
    }
    public void setANSWERC(String aNSWERC) {
        ANSWERC = aNSWERC;
    }
    public void setANSWERD(String aNSWERD) {
        ANSWERD = aNSWERD;
    }
}
