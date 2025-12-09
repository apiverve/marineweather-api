// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     MarineWeatherData data = Converter.fromJsonString(jsonString);

package com.apiverve.marineweather.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static MarineWeatherData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(MarineWeatherData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(MarineWeatherData.class);
        writer = mapper.writerFor(MarineWeatherData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// MarineWeatherData.java

package com.apiverve.marineweather.data;

import com.fasterxml.jackson.annotation.*;

public class MarineWeatherData {
    private Location location;
    private Weather weather;

    @JsonProperty("location")
    public Location getLocation() { return location; }
    @JsonProperty("location")
    public void setLocation(Location value) { this.location = value; }

    @JsonProperty("weather")
    public Weather getWeather() { return weather; }
    @JsonProperty("weather")
    public void setWeather(Weather value) { this.weather = value; }
}

// Location.java

package com.apiverve.marineweather.data;

import com.fasterxml.jackson.annotation.*;

public class Location {
    private double lat;
    private double lon;

    @JsonProperty("lat")
    public double getLat() { return lat; }
    @JsonProperty("lat")
    public void setLat(double value) { this.lat = value; }

    @JsonProperty("lon")
    public double getLon() { return lon; }
    @JsonProperty("lon")
    public void setLon(double value) { this.lon = value; }
}

// Weather.java

package com.apiverve.marineweather.data;

import com.fasterxml.jackson.annotation.*;

public class Weather {
    private double maxtempc;
    private long maxtempf;
    private double mintempc;
    private double mintempf;
    private double avgtempc;
    private double avgtempf;
    private long maxwindmph;
    private double maxwindkph;
    private double totalprecipmm;
    private double totalprecipin;
    private long totalsnowcm;
    private double avgviskm;
    private long avgvismiles;
    private String moonphase;
    private long moonillumination;

    @JsonProperty("maxtempc")
    public double getMaxtempc() { return maxtempc; }
    @JsonProperty("maxtempc")
    public void setMaxtempc(double value) { this.maxtempc = value; }

    @JsonProperty("maxtempf")
    public long getMaxtempf() { return maxtempf; }
    @JsonProperty("maxtempf")
    public void setMaxtempf(long value) { this.maxtempf = value; }

    @JsonProperty("mintempc")
    public double getMintempc() { return mintempc; }
    @JsonProperty("mintempc")
    public void setMintempc(double value) { this.mintempc = value; }

    @JsonProperty("mintempf")
    public double getMintempf() { return mintempf; }
    @JsonProperty("mintempf")
    public void setMintempf(double value) { this.mintempf = value; }

    @JsonProperty("avgtempc")
    public double getAvgtempc() { return avgtempc; }
    @JsonProperty("avgtempc")
    public void setAvgtempc(double value) { this.avgtempc = value; }

    @JsonProperty("avgtempf")
    public double getAvgtempf() { return avgtempf; }
    @JsonProperty("avgtempf")
    public void setAvgtempf(double value) { this.avgtempf = value; }

    @JsonProperty("maxwindmph")
    public long getMaxwindmph() { return maxwindmph; }
    @JsonProperty("maxwindmph")
    public void setMaxwindmph(long value) { this.maxwindmph = value; }

    @JsonProperty("maxwindkph")
    public double getMaxwindkph() { return maxwindkph; }
    @JsonProperty("maxwindkph")
    public void setMaxwindkph(double value) { this.maxwindkph = value; }

    @JsonProperty("totalprecipmm")
    public double getTotalprecipmm() { return totalprecipmm; }
    @JsonProperty("totalprecipmm")
    public void setTotalprecipmm(double value) { this.totalprecipmm = value; }

    @JsonProperty("totalprecipin")
    public double getTotalprecipin() { return totalprecipin; }
    @JsonProperty("totalprecipin")
    public void setTotalprecipin(double value) { this.totalprecipin = value; }

    @JsonProperty("totalsnowcm")
    public long getTotalsnowcm() { return totalsnowcm; }
    @JsonProperty("totalsnowcm")
    public void setTotalsnowcm(long value) { this.totalsnowcm = value; }

    @JsonProperty("avgviskm")
    public double getAvgviskm() { return avgviskm; }
    @JsonProperty("avgviskm")
    public void setAvgviskm(double value) { this.avgviskm = value; }

    @JsonProperty("avgvismiles")
    public long getAvgvismiles() { return avgvismiles; }
    @JsonProperty("avgvismiles")
    public void setAvgvismiles(long value) { this.avgvismiles = value; }

    @JsonProperty("moonphase")
    public String getMoonphase() { return moonphase; }
    @JsonProperty("moonphase")
    public void setMoonphase(String value) { this.moonphase = value; }

    @JsonProperty("moonillumination")
    public long getMoonillumination() { return moonillumination; }
    @JsonProperty("moonillumination")
    public void setMoonillumination(long value) { this.moonillumination = value; }
}