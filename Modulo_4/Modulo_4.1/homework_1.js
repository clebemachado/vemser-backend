// Criando documento
db.createCollection("playlist");

// Inserindo um
db.playlist.insertOne(
	{
		_id: 1,
		nome: "Musicas antigas",
		musicas: [
			{
				_id: "4qvUtYRNwmFzfJ2loWkQCH",
				name: "Vilarejo",
				disc_number: 1,
				popularity: 61,
				preview_url: "https://p.scdn.co/mp3-preview/0fc3d6b4c2ef69733f85d2afa146644dfa3aee4e?cid=68e29005ed5d4c838871f76bd274f6b8"
			},
			{
				_id: "6A3Q8BVAAI2PW1s6MX4ZGF",
				name: "Boa Sorte / Good Luck (feat. Ben Harper)",
				disc_number: 1,
				popularity: 63,
				preview_url: "https://p.scdn.co/mp3-preview/ee7e2c41641384fd49a50112f8970c323f669ded?cid=68e29005ed5d4c838871f76bd274f6b8"
			}
		]
	}
)

// Inserindo vários
db.playlist.insertMany(
	[
		{
			_id: 2,
			nome: "Melhores Alan Walker",
			musicas: [
				{
					_id: "7gHs73wELdeycvS48JfIos",
					name: "Faded",
					disc_number: 1,
					popularity: 72,
					preview_url: "https://p.scdn.co/mp3-preview/e99128a990c88ad3788e8b0ab55b3d301d52e3c0?cid=68e29005ed5d4c838871f76bd274f6b8"
				},
				{
					_id: "6SRWhUJcD2YKahCwHavz3X",
					name: "Darkside",
					disc_number: 1,
					popularity: 74,
					preview_url: "https://p.scdn.co/mp3-preview/b5e08f76dc4dab3e678030570da21472990d761e?cid=68e29005ed5d4c838871f76bd274f6b8"
				},
				{
					_id: "4uDhts78RdwIDjEqPrYVKp",
					name: "Sweet Dreams",
					disc_number: 1,
					popularity: 76,
					preview_url: "https://p.scdn.co/mp3-preview/651e03cd93f6c22264149166ea5c7b40d4127f0f?cid=68e29005ed5d4c838871f76bd274f6b8"
				},
				{
					id: "0lks2Kt9veMOFEAPN0fsqN",
					name: "Lily",
					disc_number: 1,
					popularity: 74,
					preview_url: "https://p.scdn.co/mp3-preview/746da4d39c7ba70816c0d0ba8714f209871b0ec6?cid=68e29005ed5d4c838871f76bd274f6b8"
				},
				{
				id: "3LlmKSHR3Rs0Y3KHQLAYDk",
				name: "Alone",
				disc_number: 1,
				popularity: 74,
				preview_url: "https://p.scdn.co/mp3-preview/197b37df40fb444d4747d55de7efa84dc219ddd5?cid=68e29005ed5d4c838871f76bd274f6b8"
				}
			]
		},
		{
			_id: 3,
			nome: "Musicas para relaxar",
			musicas: []
		},
		{
			_id: 4,
			nome: "Musicas para malhar",
			musicas: []
		}
		
	]
)


// Filtra as playlist com musicas com popularidade menor ou igual a 65
db.collection.find({
  musicas: {
    $lt: {
      popularity: 61
    }
  }
})


// Filtrar as playlist pelo nome
db.collection.find({
  nome: {
    "$regex": "musicas para*",
    "$options": "i"
  }
})