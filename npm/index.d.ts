declare module '@apiverve/marineweather' {
  export interface marineweatherOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface marineweatherResponse {
    status: string;
    error: string | null;
    data: MarineWeatherData;
    code?: number;
  }


  interface MarineWeatherData {
      location: Location;
      weather:  Weather;
  }
  
  interface Location {
      lat: number;
      lon: number;
  }
  
  interface Weather {
      maxtempc:         number;
      maxtempf:         number;
      mintempc:         number;
      mintempf:         number;
      avgtempc:         number;
      avgtempf:         number;
      maxwindmph:       number;
      maxwindkph:       number;
      totalprecipmm:    number;
      totalprecipin:    number;
      totalsnowcm:      number;
      avgviskm:         number;
      avgvismiles:      number;
      moonphase:        string;
      moonillumination: number;
  }

  export default class marineweatherWrapper {
    constructor(options: marineweatherOptions);

    execute(callback: (error: any, data: marineweatherResponse | null) => void): Promise<marineweatherResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: marineweatherResponse | null) => void): Promise<marineweatherResponse>;
    execute(query?: Record<string, any>): Promise<marineweatherResponse>;
  }
}
