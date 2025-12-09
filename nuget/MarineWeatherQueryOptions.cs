using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.MarineWeather
{
    /// <summary>
    /// Query options for the Marine Weather API
    /// </summary>
    public class MarineWeatherQueryOptions
    {
        /// <summary>
        /// The latitude coordinate of the location (e.g., 29.48003)
        /// Example: 29.48003
        /// </summary>
        [JsonProperty("lat")]
        public string Lat { get; set; }

        /// <summary>
        /// The longitude coordinate of the location (e.g., -37.62424)
        /// Example: -37.62424
        /// </summary>
        [JsonProperty("lon")]
        public string Lon { get; set; }
    }
}
