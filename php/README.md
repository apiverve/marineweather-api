# Marine Weather API - PHP Package

Marine Weather fetches offshore weather conditions for any marine coordinates by latitude and longitude. Each response details high and low temperatures, maximum wind speeds, precipitation totals, humidity, UV index, and sunrise and sunset times.

## Installation

Install via Composer:

```bash
composer require apiverve/marineweather
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Marineweather\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'lat' => 29.48003,
    'lon' => -37.62424
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Marineweather\Client;
use APIVerve\Marineweather\Exceptions\APIException;
use APIVerve\Marineweather\Exceptions\ValidationException;

try {
    $response = $client->execute(['lat' => 29.48003, 'lon' => -37.62424]);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/marineweather?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/marineweather?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/marineweather?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
