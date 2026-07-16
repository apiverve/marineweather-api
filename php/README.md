# Marine Weather API - PHP Package

Marine Weather is a simple tool for getting marine weather data. It returns the current weather conditions in coordinates within the ocean and sea.

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
      "maxtempc": 22.9,
      "maxtempf": 73.2,
      "mintempc": 21.8,
      "mintempf": 71.2,
      "avgtempc": 22.5,
      "avgtempf": 72.5,
      "maxwindmph": 11.1,
      "maxwindkph": 17.9,
      "totalprecipmm": 3.29,
      "totalprecipin": 0.13,
      "totalsnowcm": 0,
      "avgviskm": 9.9,
      "avgvismiles": 6,
      "moonphase": "Waning Crescent",
      "moonillumination": 16
    }
  }
}
```

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/marineweather?utm_source=packagist&utm_medium=readme).

## Support

- Website: [https://apiverve.com/marketplace/marineweather?utm_source=php&utm_medium=readme](https://apiverve.com/marketplace/marineweather?utm_source=php&utm_medium=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
