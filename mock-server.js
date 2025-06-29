const express = require('express');
const app = express();
const port = process.env.PORT || 3000;

const data = {
  "items": [
    {
      "type": "HighlightedProperty",
      "id": "1234567890",
      "askingPrice": "2 650 000 kr",
      "monthlyFee": "1 498 kr/mån",
      "municipality": "Gällivare kommun",
      "area": "Heden",
      "daysOnHemnet": 1,
      "livingArea": 120,
      "numberOfRooms": 5,
      "streetAddress": "Mockvägen 1",
      "image": "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5b/Hus_i_svarttorp.jpg/800px-Hus_i_svarttorp.jpg"
    },
    {
      "type": "Property",
      "id": "1234567891",
      "askingPrice": "6 950 000 kr",
      "monthlyFee": "3 498 kr/mån",
      "municipality": "Stockholm",
      "area": "Nedre Gärdet",
      "daysOnHemnet": 10,
      "livingArea": 85,
      "numberOfRooms": 3,
      "streetAddress": "Mockvägen 2",
      "image": "https://upload.wikimedia.org/wikipedia/commons/8/8f/Arkitekt_Peder_Magnussen_hus_H%C3%B8nefoss_HDR.jpg"
    },
    {
      "type": "Area",
      "id": "1234567892",
      "area": "Stockholm",
      "rating": "4.5/5",
      "averagePrice": "50 100 kr/m2",
      "image": "https://i.imgur.com/v6GDnCG.png"
    },
    {
      "type": "Property",
      "id": "1234567893",
      "askingPrice": "1 150 000 kr",
      "monthlyFee": "2 298 kr/mån",
      "municipality": "Uppsala kommun",
      "area": "Kvarngärdet",
      "daysOnHemnet": 12,
      "livingArea": 29,
      "numberOfRooms": 1,
      "streetAddress": "Mockvägen 4",
      "image": "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Bertha_Petterssons_hus_01.jpg/800px-Bertha_Petterssons_hus_01.jpg"
    },
    {
      "type": "Property",
      "id": "1234567894",
      "askingPrice": "12 490 000 kr",
      "monthlyFee": "5 100 kr/mån",
      "municipality": "Göteborgs kommun",
      "area": "Vasastaden",
      "daysOnHemnet": 1,
      "livingArea": 250,
      "numberOfRooms": 7,
      "streetAddress": "Mockvägen 5",
      "image": "https://upload.wikimedia.org/wikipedia/commons/f/f9/Navigat%C3%B8rernes_Hus_01.jpg"
    },
    {
      "type": "Property",
      "id": "1234567895",
      "askingPrice": "4 100 000 kr",
      "monthlyFee": "4 100 kr/mån",
      "municipality": "Falu kommun",
      "area": "Källviken",
      "daysOnHemnet": 4,
      "livingArea": 163,
      "numberOfRooms": 5,
      "streetAddress": "Mockvägen 6",
      "image": "https://upload.wikimedia.org/wikipedia/commons/thumb/3/37/Braskens_hus_20160717.jpg/800px-Braskens_hus_20160717.jpg"
    }
  ]
};

app.get('/listings', (req, res) => res.json(data));

app.listen(port, () => {
  console.log(`Mock backend running on http://localhost:${port}/listings`);
});
