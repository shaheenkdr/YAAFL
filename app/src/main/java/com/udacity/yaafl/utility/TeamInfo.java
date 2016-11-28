package com.udacity.yaafl.utility;

import java.util.HashMap;

/**
 *Utility class to get Team name for corresponding team ID and also to generate Team ID
 * for corresponding Team names.
 */

public class TeamInfo
{
    private static final String[] TEAM_NAME = {"Arsenal","Bournemouth","Burnley",
                                               "Chelsea","Crystal_Palace","Everton",
                                               "Hull","Leicester","Liverpool",
                                               "Manchester_City","Manchester_United","Middlesbrough",
                                               "Southampton","Stoke","Sunderland",
                                               "Swansea","Tottenham","Watford",
                                               "West_Bromwich_Albion", "West_Ham"};

    private static final String[] TEAM_NAME_PASS = {"Arsenal","Bournemouth","Burnley",
            "Chelsea","Crystal Palace","Everton",
            "Hull City","Leicester City","Liverpool",
            "Manchester City","Manchester United","Middlesbrough",
            "Southampton","Stoke City","Sunderland",
            "Swansea City","Tottenham Hotspur","Watford",
            "West Bromwich Albion", "West Ham United"};

    private static final int HOME_WIN_AVG = 46;
    private static final int AWAY_WIN_AVG = 27;
    private static HashMap<String,String> hm;
    private static HashMap<Integer,Integer> team_value;
    private static HashMap<String,String> team_logo;

    static
    {
        team_logo = new HashMap<>();
        team_logo.put("Arsenal","e0");
        team_logo.put("Bournemouth","e1");
        team_logo.put("Burnley","e2");
        team_logo.put("Chelsea","e3");
        team_logo.put("Crystal Palace","e4");
        team_logo.put("Everton","e5");
        team_logo.put("Hull City","e6");
        team_logo.put("Leicester City","e7");
        team_logo.put("Liverpool","e8");
        team_logo.put("Manchester City","e9");
        team_logo.put("Manchester United","e10");
        team_logo.put("Middlesbrough","e11");
        team_logo.put("Southampton","e12");
        team_logo.put("Stoke City","e13");
        team_logo.put("Sunderland","e14");
        team_logo.put("Swansea City","e15");
        team_logo.put("Tottenham Hotspur","e16");
        team_logo.put("Watford","e17");
        team_logo.put("West Bromwich Albion","e18");
        team_logo.put("West Ham United","e19");


        hm = new HashMap<>();
        hm.put("Arsenal VS Bournemouth", "M1X");
        hm.put("Arsenal VS Burnley", "M2X");
        hm.put("Arsenal VS Chelsea", "M3X");
        hm.put("Arsenal VS CrystalPalace", "M4X");
        hm.put("Arsenal VS Everton", "M5X");
        hm.put("Arsenal VS Hull", "M6X");
        hm.put("Arsenal VS Leicester", "M7X");
        hm.put("Arsenal VS Liverpool", "M8X");
        hm.put("Arsenal VS ManchesterCity", "M9X");
        hm.put("Arsenal VS ManchesterUnited", "M10X");
        hm.put("Arsenal VS Middlesbrough", "M11X");
        hm.put("Arsenal VS Southampton", "M12X");
        hm.put("Arsenal VS Stoke", "M13X");
        hm.put("Arsenal VS Sunderland", "M14X");
        hm.put("Arsenal VS Swansea", "M15X");
        hm.put("Arsenal VS Tottenham", "M16X");
        hm.put("Arsenal VS Watford", "M17X");
        hm.put("Arsenal VS WestBromWich", "M18X");
        hm.put("Arsenal VS WestHam", "M19X");
        hm.put("Bournemouth VS Arsenal", "M20X");
        hm.put("Bournemouth VS Burnley", "M21X");
        hm.put("Bournemouth VS Chelsea", "M22X");
        hm.put("Bournemouth VS CrystalPalace", "M23X");
        hm.put("Bournemouth VS Everton", "M24X");
        hm.put("Bournemouth VS Hull", "M25X");
        hm.put("Bournemouth VS Leicester", "M26X");
        hm.put("Bournemouth VS Liverpool", "M27X");
        hm.put("Bournemouth VS ManchesterCity", "M28X");
        hm.put("Bournemouth VS ManchesterUnited", "M29X");
        hm.put("Bournemouth VS Middlesbrough", "M30X");
        hm.put("Bournemouth VS Southampton", "M31X");
        hm.put("Bournemouth VS Stoke", "M32X");
        hm.put("Bournemouth VS Sunderland", "M33X");
        hm.put("Bournemouth VS Swansea", "M34X");
        hm.put("Bournemouth VS Tottenham", "M35X");
        hm.put("Bournemouth VS Watford", "M36X");
        hm.put("Bournemouth VS WestBromWich", "M37X");
        hm.put("Bournemouth VS WestHam", "M38X");
        hm.put("Burnley VS Arsenal", "M39X");
        hm.put("Burnley VS Bournemouth", "M40X");
        hm.put("Burnley VS Chelsea", "M41X");
        hm.put("Burnley VS CrystalPalace", "M42X");
        hm.put("Burnley VS Everton", "M43X");
        hm.put("Burnley VS Hull", "M44X");
        hm.put("Burnley VS Leicester", "M45X");
        hm.put("Burnley VS Liverpool", "M46X");
        hm.put("Burnley VS ManchesterCity", "M47X");
        hm.put("Burnley VS ManchesterUnited", "M48X");
        hm.put("Burnley VS Middlesbrough", "M49X");
        hm.put("Burnley VS Southampton", "M50X");
        hm.put("Burnley VS Stoke", "M51X");
        hm.put("Burnley VS Sunderland", "M52X");
        hm.put("Burnley VS Swansea", "M53X");
        hm.put("Burnley VS Tottenham", "M54X");
        hm.put("Burnley VS Watford", "M55X");
        hm.put("Burnley VS WestBromWich", "M56X");
        hm.put("Burnley VS WestHam", "M57X");
        hm.put("Chelsea VS Arsenal", "M58X");
        hm.put("Chelsea VS Bournemouth", "M59X");
        hm.put("Chelsea VS Burnley", "M60X");
        hm.put("Chelsea VS CrystalPalace", "M61X");
        hm.put("Chelsea VS Everton", "M62X");
        hm.put("Chelsea VS Hull", "M63X");
        hm.put("Chelsea VS Leicester", "M64X");
        hm.put("Chelsea VS Liverpool", "M65X");
        hm.put("Chelsea VS ManchesterCity", "M66X");
        hm.put("Chelsea VS ManchesterUnited", "M67X");
        hm.put("Chelsea VS Middlesbrough", "M68X");
        hm.put("Chelsea VS Southampton", "M69X");
        hm.put("Chelsea VS Stoke", "M70X");
        hm.put("Chelsea VS Sunderland", "M71X");
        hm.put("Chelsea VS Swansea", "M72X");
        hm.put("Chelsea VS Tottenham", "M73X");
        hm.put("Chelsea VS Watford", "M74X");
        hm.put("Chelsea VS WestBromWich", "M75X");
        hm.put("Chelsea VS WestHam", "M76X");
        hm.put("CrystalPalace VS Arsenal", "M77X");
        hm.put("CrystalPalace VS Bournemouth", "M78X");
        hm.put("CrystalPalace VS Burnley", "M79X");
        hm.put("CrystalPalace VS Chelsea", "M80X");
        hm.put("CrystalPalace VS Everton", "M81X");
        hm.put("CrystalPalace VS Hull", "M82X");
        hm.put("CrystalPalace VS Leicester", "M83X");
        hm.put("CrystalPalace VS Liverpool", "M84X");
        hm.put("CrystalPalace VS ManchesterCity", "M85X");
        hm.put("CrystalPalace VS ManchesterUnited", "M86X");
        hm.put("CrystalPalace VS Middlesbrough", "M87X");
        hm.put("CrystalPalace VS Southampton", "M88X");
        hm.put("CrystalPalace VS Stoke", "M89X");
        hm.put("CrystalPalace VS Sunderland", "M90X");
        hm.put("CrystalPalace VS Swansea", "M91X");
        hm.put("CrystalPalace VS Tottenham", "M92X");
        hm.put("CrystalPalace VS Watford", "M93X");
        hm.put("CrystalPalace VS WestBromWich", "M94X");
        hm.put("CrystalPalace VS WestHam", "M95X");
        hm.put("Everton VS Arsenal", "M96X");
        hm.put("Everton VS Bournemouth", "M97X");
        hm.put("Everton VS Burnley", "M98X");
        hm.put("Everton VS Chelsea", "M99X");
        hm.put("Everton VS CrystalPalace", "M100X");
        hm.put("Everton VS Hull", "M101X");
        hm.put("Everton VS Leicester", "M102X");
        hm.put("Everton VS Liverpool", "M103X");
        hm.put("Everton VS ManchesterCity", "M104X");
        hm.put("Everton VS ManchesterUnited", "M105X");
        hm.put("Everton VS Middlesbrough", "M106X");
        hm.put("Everton VS Southampton", "M107X");
        hm.put("Everton VS Stoke", "M108X");
        hm.put("Everton VS Sunderland", "M109X");
        hm.put("Everton VS Swansea", "M110X");
        hm.put("Everton VS Tottenham", "M111X");
        hm.put("Everton VS Watford", "M112X");
        hm.put("Everton VS WestBromWich", "M113X");
        hm.put("Everton VS WestHam", "M114X");
        hm.put("Hull VS Arsenal", "M115X");
        hm.put("Hull VS Bournemouth", "M116X");
        hm.put("Hull VS Burnley", "M117X");
        hm.put("Hull VS Chelsea", "M118X");
        hm.put("Hull VS CrystalPalace", "M119X");
        hm.put("Hull VS Everton", "M120X");
        hm.put("Hull VS Leicester", "M121X");
        hm.put("Hull VS Liverpool", "M122X");
        hm.put("Hull VS ManchesterCity", "M123X");
        hm.put("Hull VS ManchesterUnited", "M124X");
        hm.put("Hull VS Middlesbrough", "M125X");
        hm.put("Hull VS Southampton", "M126X");
        hm.put("Hull VS Stoke", "M127X");
        hm.put("Hull VS Sunderland", "M128X");
        hm.put("Hull VS Swansea", "M129X");
        hm.put("Hull VS Tottenham", "M130X");
        hm.put("Hull VS Watford", "M131X");
        hm.put("Hull VS WestBromWich", "M132X");
        hm.put("Hull VS WestHam", "M133X");
        hm.put("Leicester VS Arsenal", "M134X");
        hm.put("Leicester VS Bournemouth", "M135X");
        hm.put("Leicester VS Burnley", "M136X");
        hm.put("Leicester VS Chelsea", "M137X");
        hm.put("Leicester VS CrystalPalace", "M138X");
        hm.put("Leicester VS Everton", "M139X");
        hm.put("Leicester VS Hull", "M140X");
        hm.put("Leicester VS Liverpool", "M141X");
        hm.put("Leicester VS ManchesterCity", "M142X");
        hm.put("Leicester VS ManchesterUnited", "M143X");
        hm.put("Leicester VS Middlesbrough", "M144X");
        hm.put("Leicester VS Southampton", "M145X");
        hm.put("Leicester VS Stoke", "M146X");
        hm.put("Leicester VS Sunderland", "M147X");
        hm.put("Leicester VS Swansea", "M148X");
        hm.put("Leicester VS Tottenham", "M149X");
        hm.put("Leicester VS Watford", "M150X");
        hm.put("Leicester VS WestBromWich", "M151X");
        hm.put("Leicester VS WestHam", "M152X");
        hm.put("Liverpool VS Arsenal", "M153X");
        hm.put("Liverpool VS Bournemouth", "M154X");
        hm.put("Liverpool VS Burnley", "M155X");
        hm.put("Liverpool VS Chelsea", "M156X");
        hm.put("Liverpool VS CrystalPalace", "M157X");
        hm.put("Liverpool VS Everton", "M158X");
        hm.put("Liverpool VS Hull", "M159X");
        hm.put("Liverpool VS Leicester", "M160X");
        hm.put("Liverpool VS ManchesterCity", "M161X");
        hm.put("Liverpool VS ManchesterUnited", "M162X");
        hm.put("Liverpool VS Middlesbrough", "M163X");
        hm.put("Liverpool VS Southampton", "M164X");
        hm.put("Liverpool VS Stoke", "M165X");
        hm.put("Liverpool VS Sunderland", "M166X");
        hm.put("Liverpool VS Swansea", "M167X");
        hm.put("Liverpool VS Tottenham", "M168X");
        hm.put("Liverpool VS Watford", "M169X");
        hm.put("Liverpool VS WestBromWich", "M170X");
        hm.put("Liverpool VS WestHam", "M171X");
        hm.put("ManchesterCity VS Arsenal", "M172X");
        hm.put("ManchesterCity VS Bournemouth", "M173X");
        hm.put("ManchesterCity VS Burnley", "M174X");
        hm.put("ManchesterCity VS Chelsea", "M175X");
        hm.put("ManchesterCity VS CrystalPalace", "M176X");
        hm.put("ManchesterCity VS Everton", "M177X");
        hm.put("ManchesterCity VS Hull", "M178X");
        hm.put("ManchesterCity VS Leicester", "M179X");
        hm.put("ManchesterCity VS Liverpool", "M180X");
        hm.put("ManchesterCity VS ManchesterUnited", "M181X");
        hm.put("ManchesterCity VS Middlesbrough", "M182X");
        hm.put("ManchesterCity VS Southampton", "M183X");
        hm.put("ManchesterCity VS Stoke", "M184X");
        hm.put("ManchesterCity VS Sunderland", "M185X");
        hm.put("ManchesterCity VS Swansea", "M186X");
        hm.put("ManchesterCity VS Tottenham", "M187X");
        hm.put("ManchesterCity VS Watford", "M188X");
        hm.put("ManchesterCity VS WestBromWich", "M189X");
        hm.put("ManchesterCity VS WestHam", "M190X");
        hm.put("ManchesterUnited VS Arsenal", "M191X");
        hm.put("ManchesterUnited VS Bournemouth", "M192X");
        hm.put("ManchesterUnited VS Burnley", "M193X");
        hm.put("ManchesterUnited VS Chelsea", "M194X");
        hm.put("ManchesterUnited VS CrystalPalace", "M195X");
        hm.put("ManchesterUnited VS Everton", "M196X");
        hm.put("ManchesterUnited VS Hull", "M197X");
        hm.put("ManchesterUnited VS Leicester", "M198X");
        hm.put("ManchesterUnited VS Liverpool", "M199X");
        hm.put("ManchesterUnited VS ManchesterCity", "M200X");
        hm.put("ManchesterUnited VS Middlesbrough", "M201X");
        hm.put("ManchesterUnited VS Southampton", "M202X");
        hm.put("ManchesterUnited VS Stoke", "M203X");
        hm.put("ManchesterUnited VS Sunderland", "M204X");
        hm.put("ManchesterUnited VS Swansea", "M205X");
        hm.put("ManchesterUnited VS Tottenham", "M206X");
        hm.put("ManchesterUnited VS Watford", "M207X");
        hm.put("ManchesterUnited VS WestBromWich", "M208X");
        hm.put("ManchesterUnited VS WestHam", "M209X");
        hm.put("Middlesbrough VS Arsenal", "M210X");
        hm.put("Middlesbrough VS Bournemouth", "M211X");
        hm.put("Middlesbrough VS Burnley", "M212X");
        hm.put("Middlesbrough VS Chelsea", "M213X");
        hm.put("Middlesbrough VS CrystalPalace", "M214X");
        hm.put("Middlesbrough VS Everton", "M215X");
        hm.put("Middlesbrough VS Hull", "M216X");
        hm.put("Middlesbrough VS Leicester", "M217X");
        hm.put("Middlesbrough VS Liverpool", "M218X");
        hm.put("Middlesbrough VS ManchesterCity", "M219X");
        hm.put("Middlesbrough VS ManchesterUnited", "M220X");
        hm.put("Middlesbrough VS Southampton", "M221X");
        hm.put("Middlesbrough VS Stoke", "M222X");
        hm.put("Middlesbrough VS Sunderland", "M223X");
        hm.put("Middlesbrough VS Swansea", "M224X");
        hm.put("Middlesbrough VS Tottenham", "M225X");
        hm.put("Middlesbrough VS Watford", "M226X");
        hm.put("Middlesbrough VS WestBromWich", "M227X");
        hm.put("Middlesbrough VS WestHam", "M228X");
        hm.put("Southampton VS Arsenal", "M229X");
        hm.put("Southampton VS Bournemouth", "M230X");
        hm.put("Southampton VS Burnley", "M231X");
        hm.put("Southampton VS Chelsea", "M232X");
        hm.put("Southampton VS CrystalPalace", "M233X");
        hm.put("Southampton VS Everton", "M234X");
        hm.put("Southampton VS Hull", "M235X");
        hm.put("Southampton VS Leicester", "M236X");
        hm.put("Southampton VS Liverpool", "M237X");
        hm.put("Southampton VS ManchesterCity", "M238X");
        hm.put("Southampton VS ManchesterUnited", "M239X");
        hm.put("Southampton VS Middlesbrough", "M240X");
        hm.put("Southampton VS Stoke", "M241X");
        hm.put("Southampton VS Sunderland", "M242X");
        hm.put("Southampton VS Swansea", "M243X");
        hm.put("Southampton VS Tottenham", "M244X");
        hm.put("Southampton VS Watford", "M245X");
        hm.put("Southampton VS WestBromWich", "M246X");
        hm.put("Southampton VS WestHam", "M247X");
        hm.put("Stoke VS Arsenal", "M248X");
        hm.put("Stoke VS Bournemouth", "M249X");
        hm.put("Stoke VS Burnley", "M250X");
        hm.put("Stoke VS Chelsea", "M251X");
        hm.put("Stoke VS CrystalPalace", "M252X");
        hm.put("Stoke VS Everton", "M253X");
        hm.put("Stoke VS Hull", "M254X");
        hm.put("Stoke VS Leicester", "M255X");
        hm.put("Stoke VS Liverpool", "M256X");
        hm.put("Stoke VS ManchesterCity", "M257X");
        hm.put("Stoke VS ManchesterUnited", "M258X");
        hm.put("Stoke VS Middlesbrough", "M259X");
        hm.put("Stoke VS Southampton", "M260X");
        hm.put("Stoke VS Sunderland", "M261X");
        hm.put("Stoke VS Swansea", "M262X");
        hm.put("Stoke VS Tottenham", "M263X");
        hm.put("Stoke VS Watford", "M264X");
        hm.put("Stoke VS WestBromWich", "M265X");
        hm.put("Stoke VS WestHam", "M266X");
        hm.put("Sunderland VS Arsenal", "M267X");
        hm.put("Sunderland VS Bournemouth", "M268X");
        hm.put("Sunderland VS Burnley", "M269X");
        hm.put("Sunderland VS Chelsea", "M270X");
        hm.put("Sunderland VS CrystalPalace", "M271X");
        hm.put("Sunderland VS Everton", "M272X");
        hm.put("Sunderland VS Hull", "M273X");
        hm.put("Sunderland VS Leicester", "M274X");
        hm.put("Sunderland VS Liverpool", "M275X");
        hm.put("Sunderland VS ManchesterCity", "M276X");
        hm.put("Sunderland VS ManchesterUnited", "M277X");
        hm.put("Sunderland VS Middlesbrough", "M278X");
        hm.put("Sunderland VS Southampton", "M279X");
        hm.put("Sunderland VS Stoke", "M280X");
        hm.put("Sunderland VS Swansea", "M281X");
        hm.put("Sunderland VS Tottenham", "M282X");
        hm.put("Sunderland VS Watford", "M283X");
        hm.put("Sunderland VS WestBromWich", "M284X");
        hm.put("Sunderland VS WestHam", "M285X");
        hm.put("Swansea VS Arsenal", "M286X");
        hm.put("Swansea VS Bournemouth", "M287X");
        hm.put("Swansea VS Burnley", "M288X");
        hm.put("Swansea VS Chelsea", "M289X");
        hm.put("Swansea VS CrystalPalace", "M290X");
        hm.put("Swansea VS Everton", "M291X");
        hm.put("Swansea VS Hull", "M292X");
        hm.put("Swansea VS Leicester", "M293X");
        hm.put("Swansea VS Liverpool", "M294X");
        hm.put("Swansea VS ManchesterCity", "M295X");
        hm.put("Swansea VS ManchesterUnited", "M296X");
        hm.put("Swansea VS Middlesbrough", "M297X");
        hm.put("Swansea VS Southampton", "M298X");
        hm.put("Swansea VS Stoke", "M299X");
        hm.put("Swansea VS Sunderland", "M300X");
        hm.put("Swansea VS Tottenham", "M301X");
        hm.put("Swansea VS Watford", "M302X");
        hm.put("Swansea VS WestBromWich", "M303X");
        hm.put("Swansea VS WestHam", "M304X");
        hm.put("Tottenham VS Arsenal", "M305X");
        hm.put("Tottenham VS Bournemouth", "M306X");
        hm.put("Tottenham VS Burnley", "M307X");
        hm.put("Tottenham VS Chelsea", "M308X");
        hm.put("Tottenham VS CrystalPalace", "M309X");
        hm.put("Tottenham VS Everton", "M310X");
        hm.put("Tottenham VS Hull", "M311X");
        hm.put("Tottenham VS Leicester", "M312X");
        hm.put("Tottenham VS Liverpool", "M313X");
        hm.put("Tottenham VS ManchesterCity", "M314X");
        hm.put("Tottenham VS ManchesterUnited", "M315X");
        hm.put("Tottenham VS Middlesbrough", "M316X");
        hm.put("Tottenham VS Southampton", "M317X");
        hm.put("Tottenham VS Stoke", "M318X");
        hm.put("Tottenham VS Sunderland", "M319X");
        hm.put("Tottenham VS Swansea", "M320X");
        hm.put("Tottenham VS Watford", "M321X");
        hm.put("Tottenham VS WestBromWich", "M322X");
        hm.put("Tottenham VS WestHam", "M323X");
        hm.put("Watford VS Arsenal", "M324X");
        hm.put("Watford VS Bournemouth", "M325X");
        hm.put("Watford VS Burnley", "M326X");
        hm.put("Watford VS Chelsea", "M327X");
        hm.put("Watford VS CrystalPalace", "M328X");
        hm.put("Watford VS Everton", "M329X");
        hm.put("Watford VS Hull", "M330X");
        hm.put("Watford VS Leicester", "M331X");
        hm.put("Watford VS Liverpool", "M332X");
        hm.put("Watford VS ManchesterCity", "M333X");
        hm.put("Watford VS ManchesterUnited", "M334X");
        hm.put("Watford VS Middlesbrough", "M335X");
        hm.put("Watford VS Southampton", "M336X");
        hm.put("Watford VS Stoke", "M337X");
        hm.put("Watford VS Sunderland", "M338X");
        hm.put("Watford VS Swansea", "M339X");
        hm.put("Watford VS Tottenham", "M340X");
        hm.put("Watford VS WestBromWich", "M341X");
        hm.put("Watford VS WestHam", "M342X");
        hm.put("WestBromWich VS Arsenal", "M343X");
        hm.put("WestBromWich VS Bournemouth", "M344X");
        hm.put("WestBromWich VS Burnley", "M345X");
        hm.put("WestBromWich VS Chelsea", "M346X");
        hm.put("WestBromWich VS CrystalPalace", "M347X");
        hm.put("WestBromWich VS Everton", "M348X");
        hm.put("WestBromWich VS Hull", "M349X");
        hm.put("WestBromWich VS Leicester", "M350X");
        hm.put("WestBromWich VS Liverpool", "M351X");
        hm.put("WestBromWich VS ManchesterCity", "M352X");
        hm.put("WestBromWich VS ManchesterUnited", "M353X");
        hm.put("WestBromWich VS Middlesbrough", "M354X");
        hm.put("WestBromWich VS Southampton", "M355X");
        hm.put("WestBromWich VS Stoke", "M356X");
        hm.put("WestBromWich VS Sunderland", "M357X");
        hm.put("WestBromWich VS Swansea", "M358X");
        hm.put("WestBromWich VS Tottenham", "M359X");
        hm.put("WestBromWich VS Watford", "M360X");
        hm.put("WestBromWich VS WestHam", "M361X");
        hm.put("WestHam VS Arsenal", "M362X");
        hm.put("WestHam VS Bournemouth", "M363X");
        hm.put("WestHam VS Burnley", "M364X");
        hm.put("WestHam VS Chelsea", "M365X");
        hm.put("WestHam VS CrystalPalace", "M366X");
        hm.put("WestHam VS Everton", "M367X");
        hm.put("WestHam VS Hull", "M368X");
        hm.put("WestHam VS Leicester", "M369X");
        hm.put("WestHam VS Liverpool", "M370X");
        hm.put("WestHam VS ManchesterCity", "M371X");
        hm.put("WestHam VS ManchesterUnited", "M372X");
        hm.put("WestHam VS Middlesbrough", "M373X");
        hm.put("WestHam VS Southampton", "M374X");
        hm.put("WestHam VS Stoke", "M375X");
        hm.put("WestHam VS Sunderland", "M376X");
        hm.put("WestHam VS Swansea", "M377X");
        hm.put("WestHam VS Tottenham", "M378X");
        hm.put("WestHam VS Watford", "M379X");
        hm.put("WestHam VS WestBromWich", "M380X");

    }



    /**
     * Method to generate teamID
     * @param name of the team
     * @return Team Id of a team
     */
    public static int getTeamId(String name)
    {
        int val = -1;
        for(int i=0;i<TEAM_NAME.length;i++)
        {
            if(name.equals(TEAM_NAME_PASS[i]))
            {
                val = i;
                break;
            }
        }

        return val;
    }

    public static String getTeamLogo(String id)
    {
        return team_logo.get(id);
    }

    public static String getMatchId(String game)
    {
        String res = hm.get(game);
        if(res!=null)
            return res;
        else
            return "";

    }

    /**
     * method to generate the team name from its ID
     * @param id of the team
     * @return team name
     */

    public static String getTeamName(int id)
    {
        if(id>=20 ||id<0)
            return "";

        else
            return TEAM_NAME[id];

    }

    public static String getTeamNameForView(int id)
    {
        if(id>=20 ||id<0)
            return "";

        else
            return TEAM_NAME_PASS[id];

    }

    public static int getHomeWinAvg()
    {
        return HOME_WIN_AVG;
    }

    public static int getAwayWinAvg()
    {
        return AWAY_WIN_AVG;
    }

}
