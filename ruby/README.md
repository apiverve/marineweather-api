# Marine Weather API - Ruby Gem

Marine Weather fetches offshore weather conditions for any marine coordinates by latitude and longitude. Each response details high and low temperatures, maximum wind speeds, precipitation totals, humidity, UV index, and sunrise and sunset times.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_marineweather'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_marineweather
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_marineweather'

# Initialize the client
client = APIVerve::Marineweather::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  lat: 29.48003,
  lon: -37.62424
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ lat: 29.48003, lon: -37.62424 })
  puts response["data"]
rescue APIVerve::Marineweather::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Marineweather::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Marineweather::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
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

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/marineweather?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/marineweather?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/marineweather?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
