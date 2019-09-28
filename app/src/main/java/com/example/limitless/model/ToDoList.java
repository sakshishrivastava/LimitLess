package com.example.limitless.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.limitless.database.DoubleTypeConverter;
import com.example.limitless.database.StringTypeConverter;
import com.example.limitless.database.typeconverter.CurrencyTypeConverter;
import com.example.limitless.database.typeconverter.LanguageTypeConverter;
import com.example.limitless.database.typeconverter.ReginalBlocTypeConverter;
import com.example.limitless.database.typeconverter.TranslationTypeConverter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "CountryDetails")
public class ToDoList {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @SerializedName("name")
    @Expose
    @ColumnInfo(name = "name")
    private String name;
    @SerializedName("topLevelDomain")
    @Expose
    @TypeConverters(StringTypeConverter.class)
    @ColumnInfo(name = "topLevelDomain")
    private List<String> topLevelDomain = null;
    @SerializedName("alpha2Code")
    @Expose
    @ColumnInfo(name = "alpha2code")
    private String alpha2Code;
    @SerializedName("alpha3Code")
    @Expose
    @ColumnInfo(name = "alpha3code")
    private String alpha3Code;
    @SerializedName("callingCodes")
    @Expose
    @TypeConverters(StringTypeConverter.class)
    @ColumnInfo(name = "callingCodes")
    private List<String> callingCodes = null;
    @SerializedName("capital")
    @Expose
    @ColumnInfo(name = "capital")
    private String capital;
    @SerializedName("altSpellings")
    @Expose
    @TypeConverters(StringTypeConverter.class)
    @ColumnInfo(name = "altSpellings")
    private List<String> altSpellings = null;
    @SerializedName("region")
    @Expose
    @ColumnInfo(name = "region")
    private String region;
    @SerializedName("subregion")
    @Expose
    @ColumnInfo(name = "subregion")
    private String subregion;
    @SerializedName("population")
    @Expose
    @ColumnInfo(name = "population")
    private Integer population;
    @SerializedName("latlng")
    @Expose
    @TypeConverters(DoubleTypeConverter.class)
    @ColumnInfo(name = "latlng")
    private List<Double> latlng = null;
    @SerializedName("demonym")
    @Expose
    @ColumnInfo(name = "demonym")
    private String demonym;
    @SerializedName("area")
    @Expose
    @ColumnInfo(name = "area")
    private Double area;
    @SerializedName("gini")
    @Expose
    @ColumnInfo(name = "gini")
    private Double gini;
    @SerializedName("timezones")
    @Expose
    @TypeConverters(StringTypeConverter.class)
    @ColumnInfo(name = "timeZones")
    private List<String> timezones = null;
    @SerializedName("borders")
    @Expose
    @TypeConverters(StringTypeConverter.class)
    @ColumnInfo(name = "borders")
    private List<String> borders = null;
    @SerializedName("nativeName")
    @Expose
    @ColumnInfo(name = "nativeName")
    private String nativeName;
    @SerializedName("numericCode")
    @Expose
    @ColumnInfo(name = "numericCode")
    private String numericCode;
    @SerializedName("currencies")
    @Expose
    @TypeConverters(CurrencyTypeConverter.class)
    @ColumnInfo(name = "currencies")
    private List<Currency> currencies = null;
    @SerializedName("languages")
    @Expose
    @TypeConverters(LanguageTypeConverter.class)
    @ColumnInfo(name = "languages")
    private List<Language> languages = null;
    @SerializedName("translations")
    @Expose
    @ColumnInfo(name = "transltions")
    @TypeConverters(TranslationTypeConverter.class)
    private Translations translations;
    @SerializedName("flag")
    @Expose
    @ColumnInfo(name = "flag")
    private String flag;
    @SerializedName("regionalBlocs")
    @Expose
    @TypeConverters(ReginalBlocTypeConverter.class)
    @ColumnInfo(name = "regionalBlocs")
    private List<RegionalBloc> regionalBlocs = null;
    @SerializedName("cioc")
    @Expose
    @ColumnInfo(name = "cioc")
    private String cioc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTopLevelDomain() {
        return topLevelDomain;
    }

    public void setTopLevelDomain(List<String> topLevelDomain) {
        this.topLevelDomain = topLevelDomain;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public List<String> getCallingCodes() {
        return callingCodes;
    }

    public void setCallingCodes(List<String> callingCodes) {
        this.callingCodes = callingCodes;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public List<String> getAltSpellings() {
        return altSpellings;
    }

    public void setAltSpellings(List<String> altSpellings) {
        this.altSpellings = altSpellings;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public List<Double> getLatlng() {
        return latlng;
    }

    public void setLatlng(List<Double> latlng) {
        this.latlng = latlng;
    }

    public String getDemonym() {
        return demonym;
    }

    public void setDemonym(String demonym) {
        this.demonym = demonym;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getGini() {
        return gini;
    }

    public void setGini(Double gini) {
        this.gini = gini;
    }

    public List<String> getTimezones() {
        return timezones;
    }

    public void setTimezones(List<String> timezones) {
        this.timezones = timezones;
    }

    public List<String> getBorders() {
        return borders;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public Translations getTranslations() {
        return translations;
    }

    public void setTranslations(Translations translations) {
        this.translations = translations;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public List<RegionalBloc> getRegionalBlocs() {
        return regionalBlocs;
    }

    public void setRegionalBlocs(List<RegionalBloc> regionalBlocs) {
        this.regionalBlocs = regionalBlocs;
    }

    public String getCioc() {
        return cioc;
    }

    public void setCioc(String cioc) {
        this.cioc = cioc;

    }
}
