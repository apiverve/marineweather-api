/// Response models for the Marine Weather API.

/// API Response wrapper.
class MarineweatherResponse {
  final String status;
  final dynamic error;
  final MarineweatherData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  MarineweatherResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory MarineweatherResponse.fromJson(Map<String, dynamic> json) => MarineweatherResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? MarineweatherData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the Marine Weather API.

class MarineweatherData {
  MarineweatherDataLocation? location;
  MarineweatherDataWeather? weather;

  MarineweatherData({
    this.location,
    this.weather,
  });

  factory MarineweatherData.fromJson(Map<String, dynamic> json) => MarineweatherData(
      location: json['location'] != null ? MarineweatherDataLocation.fromJson(json['location']) : null,
      weather: json['weather'] != null ? MarineweatherDataWeather.fromJson(json['weather']) : null,
    );
}

class MarineweatherDataLocation {
  num? lat;
  num? lon;

  MarineweatherDataLocation({
    this.lat,
    this.lon,
  });

  factory MarineweatherDataLocation.fromJson(Map<String, dynamic> json) => MarineweatherDataLocation(
      lat: json['lat'],
      lon: json['lon'],
    );
}

class MarineweatherDataWeather {
  String? date;
  num? avghumidity;
  String? condition;
  num? uv;
  String? sunrise;
  String? sunset;
  String? moonrise;
  String? moonset;
  num? maxtempc;
  num? maxtempf;
  num? mintempc;
  num? mintempf;
  num? avgtempc;
  num? avgtempf;
  num? maxwindmph;
  num? maxwindkph;
  num? totalprecipmm;
  num? totalprecipin;
  num? totalsnowcm;
  num? avgviskm;
  num? avgvismiles;
  String? moonphase;
  num? moonillumination;

  MarineweatherDataWeather({
    this.date,
    this.avghumidity,
    this.condition,
    this.uv,
    this.sunrise,
    this.sunset,
    this.moonrise,
    this.moonset,
    this.maxtempc,
    this.maxtempf,
    this.mintempc,
    this.mintempf,
    this.avgtempc,
    this.avgtempf,
    this.maxwindmph,
    this.maxwindkph,
    this.totalprecipmm,
    this.totalprecipin,
    this.totalsnowcm,
    this.avgviskm,
    this.avgvismiles,
    this.moonphase,
    this.moonillumination,
  });

  factory MarineweatherDataWeather.fromJson(Map<String, dynamic> json) => MarineweatherDataWeather(
      date: json['date'],
      avghumidity: json['avghumidity'],
      condition: json['condition'],
      uv: json['uv'],
      sunrise: json['sunrise'],
      sunset: json['sunset'],
      moonrise: json['moonrise'],
      moonset: json['moonset'],
      maxtempc: json['maxtempc'],
      maxtempf: json['maxtempf'],
      mintempc: json['mintempc'],
      mintempf: json['mintempf'],
      avgtempc: json['avgtempc'],
      avgtempf: json['avgtempf'],
      maxwindmph: json['maxwindmph'],
      maxwindkph: json['maxwindkph'],
      totalprecipmm: json['totalprecipmm'],
      totalprecipin: json['totalprecipin'],
      totalsnowcm: json['totalsnowcm'],
      avgviskm: json['avgviskm'],
      avgvismiles: json['avgvismiles'],
      moonphase: json['moonphase'],
      moonillumination: json['moonillumination'],
    );
}

class MarineweatherRequest {
  double lat;
  double lon;

  MarineweatherRequest({
    required this.lat,
    required this.lon,
  });

  Map<String, dynamic> toJson() => {
      'lat': lat,
      'lon': lon,
    };
}
