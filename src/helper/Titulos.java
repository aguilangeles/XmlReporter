/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

/**
 *
 * @author MUTNPROD003
 */
public class Titulos {

    private String sede;
    private String idc;
    private String caratulas;
    private String campos;
    private String titulosDelTotalVolumen;

    public Titulos(String sede) {
        this.sede = sede;
        if (sede.equals("OSN")) {
        idc = IDCosn();
        caratulas = caratulasOsn();
        campos = camposOsn();
        titulosDelTotalVolumen = setTitulosVolumenOSN();
        }else if(sede.equals("GND")){
            idc=IDCosn();
            caratulas=caratulasGnd();
            campos=camposGND();
            titulosDelTotalVolumen = setTitulosVolumenGND();
        }
    }

    public Titulos() {
            idc=IDCosn();
            caratulas=caratulasOsn();
        campos = camposOsn();
    }

    private String IDCosn() {
        String ret = "";
        ret = "IDC"
                + "\tTOTAL_PAPELES"
                + "\tTOTAL_PAPELES_VALIDOS"
                + "\tTOTAL_PAPELES_INVALIDOS"
                + "\tTOTAL_CARATULAS"
                + "\tTOTAL_IMAGENES"
                + "\tTOTAL_ANVERSOS"
                + "\tTOTAL_REVERSOS"
                + "\tTOTAL_ESTADO_MAPEO"
                + "\n";
        return ret;
    }

    private String caratulasGnd() {
        String ret =  "IDC"
                +"\tESTADO"
                +"\tTIPO"
                +"\tSUBTIPO"
                +"\tC1"
                +"\tCAJA"
                +"\tANIO"
                +"\tMES"
                +"\tLIQUIDACION"
                +"\tUNIDAD"
                +"\tC2"
                +"\tMETADATO_C2"
                +"\tC3"
                +"\tMETADATO_C3"
                +"\tC4"
                +"\tMETADATO_C4"
                +"\n      ";

        return ret;
    }
    private String caratulasOsn() {
        String ret =  "IDC"
                +"\tESTADO"
                +"\tTIPO"
                +"\tSUBTIPO"
                +"\tCANTIDAD_SUMARIAS"
                +"\tC1"
                +"\tCAJA"
                +"\tBANCO"
                +"\tSUCURSAL"
                +"\tFECHA_PRES"
                +"\tC3"
                +"\tMETADATO_C3"
                +"\tC4"
                +"\tMETADATO_C4"
                +"\n      ";

        return ret;
    }
    private String camposOsn(){
        String ret ="IDC"
               +"\tDISTRITO_VALID"
               +"\tDISTRITO_INVALID"
               +"\tPARTIDA_VALID"
               +"\tPARTIDA_INVALID"
               +"\tSUBCUENTA_VALID"
               +"\tSUBCUENTA_INVALID"
               +"\tDIGITO_VALID"
               +"\tDIGITO_INVALID"
               +"\tANIO_VALID"
               +"\tANIO_INVALID"
               +"\tBIMESTRE_VALID"
               +"\tBIMESTRE_INVALID"
               +"\tTOTAL_CAMPOS"
               +"\tTOTAL_CAMPOS_VALID"
               +"\tTOTAL_CAMPOS_INVALID"
               +"\tPORC_CMP_VALID"
               +"\tPORC_CMP_INVALID"
               +"\n";
        return ret;
    }
    private String camposGND(){
        String ret ="IDC"
               +"\tGRADO_VALID"
               +"\tGRADO_INVALID"
               +"\tGRADO_INVALIDDB"
               +"\tCODEST_VALID"
               +"\tCODEST_INVALID"
               +"\tCODEST_INVALIDDB"
               +"\tTOTAL_CAMPOS"
               +"\tTOTAL_CAMPOS_VALID"
               +"\tTOTAL_CAMPOS_INVALID"
               +"\tTOTAL_CAMPOS_INVALIDDB"
               +"\tPORC_CMP_VALID"
               +"\tPORC_CMP_INVALID"
               +"\tPORC_CMP_INVALIDDB"
               +"\n";
        return ret;
    }
    private String setTitulosVolumenGND() {
       // String copete = "Totales del Volumen: " + this.volumen + "\n";
        titulosDelTotalVolumen =
                 "Papeles" + "\tPap Validos" + "\tPap Invalidos" + "\tImagenes"
                + "\tAnversos"
                + "\tReversos"
                + "\tCampoMeta" + "\tCamp_Valid" + "\tCamp_Invalid" + "\tCamp_InvalidDB"
                + "\tCamp_Valid(%)" + "\tCamp_Invalid(%)"+"\tCamp_InvalidDB(%)\n";

        return titulosDelTotalVolumen;
    }
    private String setTitulosVolumenOSN() {
       // String copete = "Totales del Volumen: " + this.volumen + "\n";
        titulosDelTotalVolumen =
                 "Papeles" + "\tPap Validos" + "\tPap Invalidos" + "\tImagenes"
                + "\tAnversos"
                + "\tReversos"
                + "\tCampoMeta" + "\tCamp_Valid" + "\tCamp_Invalid"
                + "\tCamp_Valid(%)" + "\tCamp_Invalid(%)"+"\n";

        return titulosDelTotalVolumen;
    }
    public String getIdc() {
        return idc;
    }

    public String getCaratulas() {
        return caratulas;
    }

    public String getCampos() {
        return campos;
    }

    public String getTitulosDelTotalVolumen() {
        return titulosDelTotalVolumen;
    }


}
