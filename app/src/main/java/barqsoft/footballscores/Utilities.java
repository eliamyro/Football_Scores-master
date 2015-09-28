package barqsoft.footballscores;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;

/**
 * Created by yehya khaled on 3/3/2015.
 */
public class Utilities
{
    public static final int BUNDESLIGA1 = 394;
    public static final int BUNDESLIGA2 = 395;
    public static final int LIGUE1 = 396;
    public static final int LIGUE2 = 397;
    public static final int PREMIER_LEAGUE = 398;
    public static final int PRIMERA_DIVISION = 399;
    public static final int SEGUNDA_DIVISION = 400;
    public static final int SERIE_A = 401;
    public static final int PRIMERA_LIGA = 402;
    public static final int BUNDESLIGA3 = 403;
    public static final int EREDIVISIE = 404;
    public static final int CHAMPIONS_LEAGUE = 405;

    public static String getLeague(int league_num, Context context)
    {
        switch (league_num)
        {
            case BUNDESLIGA1 : return context.getString(R.string.bundesliga1);
            case BUNDESLIGA2 : return context.getString(R.string.bundesliga2);
            case LIGUE1 : return context.getString(R.string.ligue1);
            case LIGUE2 : return context.getString(R.string.ligue2);
            case PREMIER_LEAGUE : return context.getString(R.string.premier_league);
            case PRIMERA_DIVISION : return context.getString(R.string.primera_division);
            case SEGUNDA_DIVISION : return context.getString(R.string.segunda_division);
            case SERIE_A : return context.getString(R.string.serie_a);
            case PRIMERA_LIGA : return context.getString(R.string.primera_liga);
            case BUNDESLIGA3 : return context.getString(R.string.bundesliga3);
            case EREDIVISIE : return context.getString(R.string.eredivisie);
            case CHAMPIONS_LEAGUE : return context.getString(R.string.champions_league);
            default: return context.getString(R.string.not_known_league);
        }
    }

    public static String getMatchDay(int match_day,int league_num)
    {
        if(league_num == CHAMPIONS_LEAGUE)
        {
            if (match_day <= 6)
            {
                return "Group Stages, Matchday : 6";
            }
            else if(match_day == 7 || match_day == 8)
            {
                return "First Knockout round";
            }
            else if(match_day == 9 || match_day == 10)
            {
                return "QuarterFinal";
            }
            else if(match_day == 11 || match_day == 12)
            {
                return "SemiFinal";
            }
            else
            {
                return "Final";
            }
        }
        else
        {
            return "Matchday : " + String.valueOf(match_day);
        }
    }

    public static String getScores(int home_goals,int awaygoals)
    {
        if(home_goals < 0 || awaygoals < 0)
        {
            return " - ";
        }
        else
        {
            return String.valueOf(home_goals) + " - " + String.valueOf(awaygoals);
        }
    }

    public static int inversePositionForRTL(int position, int total)
    {
        return total - position - 1;
    }

    public static boolean isLayoutRTL (Context context){
        Configuration config = context.getResources().getConfiguration();
        if(config.getLayoutDirection() == View.LAYOUT_DIRECTION_RTL) {
            return true;
        }

        return false;
    }

    public static int getTeamCrestByTeamName (String teamname)
    {
        if (teamname==null){return R.drawable.no_icon;}
        switch (teamname)
        { //This is the set of icons that are currently in the app. Feel free to find and add more
            //as you go.

            // Bundesliga 1
            case "FC Bayern München" : return R.drawable.bayern_munchen;
            case "Hamburger SV" : return R.drawable.hamburger_sv;
            case "FC Augsburg" : return R.drawable.augsburg;
            case "Bayer Leverkusen" : return R.drawable.bayer_leverkusen;
            case "TSG 1899 Hoffenheim" : return R.drawable.hoffenheim;
            case "SV Darmstadt 98" : return R.drawable.sv_darmstadt;
            case "Hannover 96" : return R.drawable.hannover_96;
            case "1. FSV Mainz 05" : return R.drawable.mainz_05;
            case "FC Ingolstadt 04" : return R.drawable.fc_ingolstadt04;
            case "Werder Bremen" : return R.drawable.werder_bremen;
            case "FC Schalke 04" : return R.drawable.schalke_04;
            case "Borussia Dortmund" : return R.drawable.borussia_dortmund;
            case "Bor. Mönchengladbach" : return R.drawable.borussia_mc3b6nchengladbach;
            case "VfL Wolfsburg" : return R.drawable.wolfsburg;
            case "Eintracht Frankfurt" : return R.drawable.eintracht_frankfurt;
            case "VfB Stuttgart" : return R.drawable.vfb_stuttgart;
            case "1. FC Köln" : return R.drawable.fc_koln;
            case "Hertha BSC" : return R.drawable.hertha_berlin;

            // Bundesliga 2
            case "MSV Duisburg" : return R.drawable.msv_duisburg;
            case "1. FC Kaiserslautern" : return R.drawable.fc_kaiserslautern;
            case "Eintracht Braunschweig" : return R.drawable.eintracht_braunschweig;
            case "SV Sandhausen" : return R.drawable.sv_sandhausen;
            case "SC Freiburg" : return R.drawable.sc_freiburg;
            case "1. FC Nürnberg" : return R.drawable.fc_nuremberg;
            case "FSV Frankfurt" : return R.drawable.fsv_frankfurt;
            case "Red Bull Leipzig" : return R.drawable.rasenballsport_leipzig;
            case "SpVgg Greuther Fürth" : return R.drawable.spvgg_greuther_fc3bcrth;
            case "Karlsruher SC" : return R.drawable.karlsruher_sc;
            case "1. FC Heidenheim 1846" : return R.drawable.fc_heidenheim_1846;
            case "TSV 1860 München" : return R.drawable.tsv_1860_munich;
            case "SC Paderborn 07" : return R.drawable.sc_paderborn;
            case "VfL Bochum" : return R.drawable.vfl_bochum;
            case "FC St. Pauli" : return R.drawable.fc_st_pauli;
            case "Arminia Bielefeld" : return R.drawable.arminia_bielefeld;
            case "1. FC Union Berlin" : return R.drawable.fc_union_berlin;
            case "Fortuna Düsseldorf" : return R.drawable.fortuna_dc3bcsseldorf;

            // Ligue 1
            case"OSC Lille" : return R.drawable.lille_osc;
            case"Paris Saint-Germain" : return R.drawable.paris_saint_germain_fc;
            case"ES Troyes AC" : return R.drawable.es_troyes_ac;
            case"Gazélec Ajaccio" : return R.drawable.ajaccio_gazel;
            case"Olympique de Marseille" : return R.drawable.marseille;
            case"SM Caen" : return R.drawable.sm_caen;
            case"OGC Nice" : return R.drawable.ogc_nice;
            case"AS Monaco FC" : return R.drawable.as_monaco_fc;
            case"FC Nantes" : return R.drawable.fc_nantes;
            case"EA Guingamp" : return R.drawable.en_avant_de_guingamp;
            case"Montpellier Hérault SC" : return R.drawable.montpellier;
            case"Angers SCO" : return R.drawable.angers_sco;
            case"SC Bastia" : return R.drawable.sc_bastia;
            case"Stade Rennais FC" : return R.drawable.stade_rennais;
            case"FC Girondins de Bordeaux" : return R.drawable.bordeaux;
            case"Stade de Reims" : return R.drawable.stade_reims;
            case"Toulouse FC" : return R.drawable.toulouse;
            case"AS Saint-Étienne" : return R.drawable.saint_etienne;
            case"Olympique Lyonnais" : return R.drawable.lyon;
            case"FC Lorient" : return R.drawable.lorient_fc;

            // Ligue 2
            case"Ajaccio AC" : return R.drawable.ajaccio;
            case"Dijon FCO" : return R.drawable.dijon;
            case"Paris FC" : return R.drawable.lille_osc;
            case"FC Stade Lavallois Mayenne" : return R.drawable.stade_lavallois;
            case"Chamois Niortais FC" : return R.drawable.chamois_niortais;
            case"FC Valenciennes" : return R.drawable.valenciennes;
            case"Nîmes Olympique" : return R.drawable.nimes_olympique;
            case"Évian Thonon Gaillard FC" : return R.drawable.evian_thonon;
            case"Red Star 93" : return R.drawable.red_star;
            case"US Créteil" : return R.drawable.creteil;
            case"Clermont Foot Auvergne" : return R.drawable.clermontfoot;
            case"Sochaux FC" : return R.drawable.sochaux;
            case"FC Bourg-en-Bresse Péronnas" : return R.drawable.bourg_en_bresse;
            case"Le Havre AC" : return R.drawable.le_havre;
            case"AJ Auxerre" : return R.drawable.aj_auxerre;
            case"Stade Brestois" : return R.drawable.stade_brestois;
            case"FC Metz" : return R.drawable.fc_metz;
            case"RC Lens" : return R.drawable.rc_lens;
            case"AS Nancy" : return R.drawable.as_nancy;
            case"RC Tours" : return R.drawable.rc_tours;

            // Premier League
            case "Manchester United FC" : return R.drawable.manchester_united;
            case "Tottenham Hotspur FC" : return R.drawable.tottenham_hotspur;
            case "AFC Bournemouth" : return R.drawable.afc_bournemouth;
            case "Aston Villa FC" : return R.drawable.aston_villa;
            case "Everton FC" : return R.drawable.everton_fc_logo1;
            case "Watford FC" : return R.drawable.watford_fc;
            case "Leicester City FC" : return R.drawable.leicester_city_fc_hd_logo;
            case "Sunderland AFC" : return R.drawable.sunderland;
            case "Norwich City FC" : return R.drawable.norwich_city_fc;
            case "Crystal Palace FC" : return R.drawable.crystal_palace_fc;
            case "Chelsea FC" : return R.drawable.chelsea;
            case "Swansea City FC" : return R.drawable.swansea_city_afc;
            case "Newcastle United FC" : return R.drawable.newcastle_united;
            case "Southampton FC" : return R.drawable.southampton_fc;
            case "Arsenal FC" : return R.drawable.arsenal;
            case "West Ham United FC" : return R.drawable.west_ham;
            case "Stoke City FC" : return R.drawable.stoke_city;
            case "Liverpool FC" : return R.drawable.liverpool;
            case "West Bromwich Albion FC" : return R.drawable.west_bromwich_albion_hd_logo;
            case "Manchester City FC" : return R.drawable.manchester_city;

            // Primera Division
            case "RC Deportivo La Coruna" : return R.drawable.deportivo_la_coruna;
            case "Real Sociedad de Fútbol" : return R.drawable.real_sociedad;
            case "RCD Espanyol" : return R.drawable.espanyol;
            case "Getafe CF" : return R.drawable.getafe;
            case "Club Atlético de Madrid" : return R.drawable.atlc3a9tico_madrid;
            case "UD Las Palmas" : return R.drawable.las_palmas;
            case "Rayo Vallecano de Madrid" : return R.drawable.rayo_vallecano;
            case "Valencia CF" : return R.drawable.valencia;
            case "Málaga CF" : return R.drawable.mc3a1laga;
            case "Sevilla FC" : return R.drawable.sevilla;
            case "Athletic Club" : return R.drawable.athletic_bilbao;
            case "FC Barcelona" : return R.drawable.barcelona_fc;
            case "Sporting Gijón" : return R.drawable.sporting_gijon;
            case "Real Madrid CF" : return R.drawable.real_madrid;
            case "Levante UD" : return R.drawable.levante_ud;
            case "RC Celta de Vigo" : return R.drawable.celta_vigo;
            case "Real Betis" : return R.drawable.real_betis;
            case "Villarreal CF" : return R.drawable.villarreal;
            case "Granada CF" : return R.drawable.granada_cf;
            case "SD Eibar" : return R.drawable.eibar_sd;

            // Segunda Division
            case "CD Mirandes" : return R.drawable.mirandes;
            case "Real Zaragoza" : return R.drawable.real_zaragoza;
            case "Real Oviedo" : return R.drawable.real_oviedo;
            case "CD Lugo" : return R.drawable.lugo;
            case "SD Ponferradina" : return R.drawable.ponferradina;
            case "Elche FC" : return R.drawable.elche_cf;
            case "CD Numancia de Soria" : return R.drawable.numancia;
            case "CD Tenerife" : return R.drawable.tenerife;
            case "AD Alcorcón" : return R.drawable.alcorcon;
            case "RCD Mallorca" : return R.drawable.rcd_mallorca;
            case "UE Llagostera" : return R.drawable.llagostera;
            case "CA Osasuna" : return R.drawable.ca_osasuna;
            case "Huesca" : return R.drawable.huesca;
            case "Deportivo Alavés" : return R.drawable.deportivo_alaves;
            case "UD Almeria" : return R.drawable.ud_almeria;
            case "CD Leganes" : return R.drawable.cd_leganes;
            case "Gimnàstic de Tarragona" : return R.drawable.gimnastic_de_tarragona;
            case "Albacete" : return R.drawable.albacete;
            case "Córdoba CF" : return R.drawable.cordoba_cf;
            case "Real Valladolid" : return R.drawable.real_valladolid;
            case "Athletic Bilbao B" : return R.drawable.athletic_bilbao;
            case "Girona FC" : return R.drawable.girona;

            // Serie A
            case "Hellas Verona FC" : return R.drawable.hellas_verona;
            case "AS Roma" : return R.drawable.as_roma;
            case "Juventus Turin" : return R.drawable.juventus;
            case "Udinese Calcio" : return R.drawable.udinese_calcio;
            case "US Cittá di Palermo" : return R.drawable.palermo;
            case "Genoa CFC" : return R.drawable.genoa;
            case "US Sassuolo Calcio" : return R.drawable.sassuolo_calcio;
            case "SSC Napoli" : return R.drawable.napoli;
            case "UC Sampdoria" : return R.drawable.sampdoria_genua;
            case "Carpi FC" : return R.drawable.carpi;
            case "SS Lazio" : return R.drawable.lazio;
            case "Bologna FC" : return R.drawable.bologna;
            case "FC Internazionale Milano" : return R.drawable.inter_milan;
            case "Atalanta BC" : return R.drawable.atalanta;
            case "Frosinone Calcio" : return R.drawable.frosinone_calcio;
            case "Torino FC" : return R.drawable.torino_fc;
            case "ACF Fiorentina" : return R.drawable.fiorentina;
            case "AC Milan" : return R.drawable.milan;
            case "Empoli FC" : return R.drawable.empoli_fc;
            case "AC Chievo Verona" : return R.drawable.ac_chievo_verona;

            // Bundesliga 3
            case "Magdeburg" : return R.drawable.magdeburg;
            case "Rot-Weiß Erfurt" : return R.drawable.rot_weis;
            case "SV Wehen Wiesbaden" : return R.drawable.sv_wehen_wiesbaden;
            case "W&uuml;rzburger Kickers" : return R.drawable.kickers_wurzburg;
            case "FC Hansa Rostock" : return R.drawable.hansa_rostock;
            case "Werder Bremen II" : return R.drawable.werder_bremen;
            case "Stuttgarter Kickers" : return R.drawable.stuttgarter_kickers;
            case "Fortuna Köln" : return R.drawable.fortuna_koln;
            case "Preußen Münster" : return R.drawable.preusen_munster;
            case "SG Sonnenhof Großaspach" : return R.drawable.sonnenhof;
            case "Holstein Kiel" : return R.drawable.holstein_kiel;
            case "Mainz 05 II" : return R.drawable.mainz_05;
            case "Erzgebirge Aue" : return R.drawable.ergebirge;
            case "VfL Osnabrück" : return R.drawable.osnabruck;
            case "Dynamo Dresden" : return R.drawable.dynamo_dresden;
            case "VfB Stuttgart II" : return R.drawable.vfb_stuttgart;
            case "VfR Aalen" : return R.drawable.vfr_aalen;
            case "Chemnitzer FC" : return R.drawable.chemnitz;
            case "Energie Cottbus" : return R.drawable.energie_cottbus;
            case "Hallescher FC" : return R.drawable.hallescher;

            // Eredivisie
            case "Roda JC Kerkrade" : return R.drawable.roda_jc_kerkrade;
            case "Heracles Almelo" : return R.drawable.heracles_almelo;
            case "Feyenoord Rotterdam" : return R.drawable.feyenoord_rotterdam;
            case "FC Utrecht" : return R.drawable.utrecht_fc;
            case "AZ Alkmaar" : return R.drawable.az_alkmaar;
            case "Ajax Amsterdam" : return R.drawable.ajax_amsterdam;
            case "Willem II" : return R.drawable.willem_ii_tilburg;
            case "Vitesse Arnhem" : return R.drawable.vitesse;
            case "ADO Den Haag" : return R.drawable.ado_den_haag;
            case "PSV Eindhoven" : return R.drawable.psv_eindhoven;
            case "SC Heerenveen" : return R.drawable.heerenveen_sc;
            case "De Graafschap" : return R.drawable.degraafschap;
            case "FC Groningen" : return R.drawable.groningen_fc;
            case "FC Twente Enschede" : return R.drawable.twente;
            case "PEC Zwolle" : return R.drawable.pec_zwolle;
            case "SC Cambuur-Leeuwarden" : return R.drawable.cambuur_leeuwarden;
            case "NEC Nijmegen" : return R.drawable.nec_nijmegen;
            case "Excelsior" : return R.drawable.excelsior;

            // Primera Liga
            case "CD Tondela" : return R.drawable.cd_tondela;
            case "Sporting Lisbon" : return R.drawable.sporting_lisbon;
            case "Belenenses Lissabon" : return R.drawable.belenenses_cf;
            case "FC Rio Ave" : return R.drawable.rio_ave_fc;
            case "FC Porto" : return R.drawable.porto_fc;
            case "Vitoria Guimaraes" : return R.drawable.vitoria_guimaraes;
            case "Vitoria Setubal" : return R.drawable.vitoria_setubal;
            case "Boavista Porto FC" : return R.drawable.bfc_boavista;
            case "União Madeira" : return R.drawable.nacional_madeira;
            case "Maritimo Funchal" : return R.drawable.maritimo_funchal;
            case "Moreirense FC" : return R.drawable.moreirense;
            case "FC Arouca" : return R.drawable.arouca_fc;
            case "Sporting Braga" : return R.drawable.sporting_braga;
            case "Nacional Funchal" : return R.drawable.nacional_funchal;
            case "Benfica Lissabon" : return R.drawable.benfica_sl;
            case "GD Estoril Praia" : return R.drawable.estoril_praia;
            case "FC Paços de Ferreira" : return R.drawable.pacos_ferreira;
            case "Académica de Coimbra" : return R.drawable.academica_de_coimbra;

            // Champions League
            case "Malmö FF" : return R.drawable.malmo_ff;
            case "FC Astana" : return R.drawable.astana;
            case "Galatasaray SK" : return R.drawable.galatasaray;
            case "CSKA Moscow" : return R.drawable.cska_moscow;
            case "Shakhtar Donetsk" : return R.drawable.shakhtar_donetsk;
            case "FC Zenit St. Petersburg" : return R.drawable.fc_zenit;
            case "Dynamo Kyiv" : return R.drawable.dynamo_kiev;
            case "Maccabi Tel Aviv" : return R.drawable.maccabi_telaviv;
            case "Olympiacos F.C." : return R.drawable.olympiacos;
            case "GNK Dinamo Zagreb" : return R.drawable.dinamo_zagreb;
            case "FK BATE Baryssau" : return R.drawable.bate_borisov;
            case "KAA Gent" : return R.drawable.kaa_gent;
            default: return R.drawable.no_icon;
        }
    }
}
