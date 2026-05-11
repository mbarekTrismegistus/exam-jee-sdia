export interface Vehicule {
    id?: number;
    marque: string;
    modele: string;
    matricule: string;
    prixParJour: number;
    dateMiseEnService: string;
    statut: 'DISPONIBLE' | 'LOUE' | 'EN_MAINTENANCE';
    agenceId?: number;
  
    nombrePortes?: number;
    typeCarburant?: 'ESSENCE' | 'DIESEL' | 'HYBRIDE' | 'ELECTRIQUE';
    boiteVitesse?: 'MANUELLE' | 'AUTOMATIQUE';
    cylindree?: number;
    typeMoto?: 'SPORTIVE' | 'SCOOTER' | 'ROADSTER' | 'TOURING';
    casqueInclus?: 'OUI' | 'NON';
  }