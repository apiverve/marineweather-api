declare module '@apiverve/marineweather' {
  export interface marineweatherOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface marineweatherResponse {
    status: string;
    error: string | null;
    data: MarineWeatherData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface MarineWeatherData {
      location: Location;
      weather:  Weather;
  }
  
  interface Location {
      lat: number | null;
      lon: number | null;
  }
  
  interface Weather {
      maxtempc:         number | null;
      maxtempf:         number | null;
      mintempc:         number | null;
      mintempf:         number | null;
      avgtempc:         number | null;
      avgtempf:         number | null;
      maxwindmph:       number | null;
      maxwindkph:       number | null;
      totalprecipmm:    number | null;
      totalprecipin:    number | null;
      totalsnowcm:      number | null;
      avgviskm:         number | null;
      avgvismiles:      number | null;
      moonphase:        null | string;
      moonillumination: number | null;
  }

  export default class marineweatherWrapper {
    constructor(options: marineweatherOptions);

    execute(callback: (error: any, data: marineweatherResponse | null) => void): Promise<marineweatherResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: marineweatherResponse | null) => void): Promise<marineweatherResponse>;
    execute(query?: Record<string, any>): Promise<marineweatherResponse>;
  }
}
