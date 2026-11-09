# Marine Weather API - Dart/Flutter Client

Marine Weather fetches offshore weather conditions for any marine coordinates by latitude and longitude. Each response details high and low temperatures, maximum wind speeds, precipitation totals, humidity, UV index, and sunrise and sunset times.

[![pub package](https://img.shields.io/pub/v/apiverve_marineweather.svg)](https://pub.dev/packages/apiverve_marineweather)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Marine Weather API](https://apiverve.com/marketplace/marineweather?utm_source=dart&utm_medium=referral&utm_content=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_marineweather: ^1.2.5
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_marineweather/apiverve_marineweather.dart';

void main() async {
  final client = MarineweatherClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'lat': 29.48003,
      'lon': -37.62424
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "location": {
      "lat": 29.48003,
      "lon": -37.62424
    },
    "weather": {
      "date": "2026-09-17",
      "avghumidity": 86,
      "condition": "Moderate or heavy rain shower",
      "uv": 5,
      "sunrise": "05:53 AM",
      "sunset": "06:08 PM",
      "moonrise": "12:04 PM",
      "moonset": "10:42 PM",
      "maxtempc": 25.9,
      "maxtempf": 78.6,
      "mintempc": 21.3,
      "mintempf": 70.3,
      "avgtempc": 24.9,
      "avgtempf": 76.8,
      "maxwindmph": 15.4,
      "maxwindkph": 24.7,
      "totalprecipmm": 14.89,
      "totalprecipin": 0.59,
      "totalsnowcm": 0,
      "avgviskm": 7.4,
      "avgvismiles": 4,
      "moonphase": "First Quarter",
      "moonillumination": 42
    }
  }
}
```

## API Reference

- **API Home:** [Marine Weather API](https://apiverve.com/marketplace/marineweather?utm_source=dart&utm_medium=referral&utm_content=readme)
- **Documentation:** [docs.apiverve.com/ref/marineweather](https://docs.apiverve.com/ref/marineweather?utm_source=dart&utm_medium=referral&utm_content=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme)
