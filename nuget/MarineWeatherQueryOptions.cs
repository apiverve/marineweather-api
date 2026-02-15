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
        /// The latitude coordinate of the location
        /// </summary>
        [JsonProperty("lat")]
        public string Lat { get; set; }

        /// <summary>
        /// The longitude coordinate of the location
        /// </summary>
        [JsonProperty("lon")]
        public string Lon { get; set; }
    }
}
