Marine Weather API
============

Marine Weather fetches offshore weather conditions for any marine coordinates by latitude and longitude. Each response details high and low temperatures, maximum wind speeds, precipitation totals, humidity, UV index, and sunrise and sunset times.


[![PyPI version](https://img.shields.io/pypi/v/apiverve-marineweather.svg)](https://pypi.org/project/apiverve-marineweather/)

This is a Python wrapper for the [Marine Weather API](https://apiverve.com/marketplace/marineweather?utm_source=pypi&utm_medium=referral&utm_content=readme)

---

## Installation

Using `pip`:

```bash
pip install apiverve-marineweather
```

Using `pip3`:

```bash
pip3 install apiverve-marineweather
```

---

## Configuration

Before using the Marine Weather API client, you have to setup your account and obtain your API Key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com?utm_source=pypi&utm_medium=referral&utm_content=readme)

---

## Quick Start

Here's a simple example to get you started quickly:

```python
from apiverve_marineweather.apiClient import MarineweatherAPIClient

# Initialize the client with your APIVerve API key
api = MarineweatherAPIClient("[YOUR_API_KEY]")

query = {
    "lat": 29.48003,
    "lon": -37.62424
}

try:
    # Make the API call
    result = api.execute(query)

    # Print the result
    print(result)
except Exception as e:
    print(f"Error: {e}")
```

---

## Usage

The Marine Weather API documentation is found here: [https://docs.apiverve.com/ref/marineweather](https://docs.apiverve.com/ref/marineweather?utm_source=pypi&utm_medium=referral&utm_content=readme).
You can find parameters, example responses, and status codes documented here.

### Setup

```python
# Import the client module
from apiverve_marineweather.apiClient import MarineweatherAPIClient

# Initialize the client with your APIVerve API key
api = MarineweatherAPIClient("[YOUR_API_KEY]")
```

---

## Perform Request

Using the API client, you can perform requests to the API.

###### Define Query

```python
query = {
    "lat": 29.48003,
    "lon": -37.62424
}
```

###### Simple Request

```python
# Make a request to the API
result = api.execute(query)

# Print the result
print(result)
```

###### Example Response

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

---

## Error Handling

The API client provides comprehensive error handling through the `MarineweatherAPIClientError` exception. Here are some examples:

### Basic Error Handling

```python
from apiverve_marineweather.apiClient import MarineweatherAPIClient, MarineweatherAPIClientError

api = MarineweatherAPIClient("[YOUR_API_KEY]")

query = {
    "lat": 29.48003,
    "lon": -37.62424
}

try:
    result = api.execute(query)
    print("Success!")
    print(result)
except MarineweatherAPIClientError as e:
    print(f"API Error: {e.message}")
    if e.status_code:
        print(f"Status Code: {e.status_code}")
    if e.response:
        print(f"Response: {e.response}")
```

### Handling Specific Error Types

```python
from apiverve_marineweather.apiClient import MarineweatherAPIClient, MarineweatherAPIClientError

api = MarineweatherAPIClient("[YOUR_API_KEY]")

query = {
    "lat": 29.48003,
    "lon": -37.62424
}

try:
    result = api.execute(query)

    # Check for successful response
    if result.get('status') == 'success':
        print("Request successful!")
        print(result.get('data'))
    else:
        print(f"API returned an error: {result.get('error')}")

except MarineweatherAPIClientError as e:
    # Handle API client errors
    if e.status_code == 401:
        print("Unauthorized: Invalid API key")
    elif e.status_code == 429:
        print("Rate limit exceeded")
    elif e.status_code >= 500:
        print("Server error - please try again later")
    else:
        print(f"API error: {e.message}")
except Exception as e:
    # Handle unexpected errors
    print(f"Unexpected error: {str(e)}")
```

### Using Context Manager (Recommended)

The client supports the context manager protocol for automatic resource cleanup:

```python
from apiverve_marineweather.apiClient import MarineweatherAPIClient, MarineweatherAPIClientError

query = {
    "lat": 29.48003,
    "lon": -37.62424
}

# Using context manager ensures proper cleanup
with MarineweatherAPIClient("[YOUR_API_KEY]") as api:
    try:
        result = api.execute(query)
        print(result)
    except MarineweatherAPIClientError as e:
        print(f"Error: {e.message}")
# Session is automatically closed here
```

---

## Advanced Features

### Debug Mode

Enable debug logging to see detailed request and response information:

```python
from apiverve_marineweather.apiClient import MarineweatherAPIClient

# Enable debug mode
api = MarineweatherAPIClient("[YOUR_API_KEY]", debug=True)

query = {
    "lat": 29.48003,
    "lon": -37.62424
}

# Debug information will be printed to console
result = api.execute(query)
```

### Manual Session Management

If you need to manually manage the session lifecycle:

```python
from apiverve_marineweather.apiClient import MarineweatherAPIClient

api = MarineweatherAPIClient("[YOUR_API_KEY]")

query = {
    "lat": 29.48003,
    "lon": -37.62424
}

try:
    result = api.execute(query)
    print(result)
finally:
    # Manually close the session when done
    api.close()
```

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact?utm_source=pypi&utm_medium=referral&utm_content=readme).

---

## Updates
Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms?utm_source=pypi&utm_medium=referral&utm_content=readme) and all legal documents and agreements.

---

## License
Licensed under the MIT License (MIT)

Copyright (&copy;) 2026 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
