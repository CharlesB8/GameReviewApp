package game.review.controller;

public class OpenAPIExampleResponses {
    private OpenAPIExampleResponses() {}

    public static final String GET_USER_DUMMY_RESPONSE =
            """
            {
                "id": "1",
                "username": "DonkeyKong",
                "email": "donkeykong@gmail.com",
                "first_name": "Donkey",
                "last_name": "Kong",
                "bio": "I love games with monkeys",
                "thumbnail_src": "some/url/somewhere
            }
            """;

    public static final String UPDATE_USER_DUMMY_RESPONSE =
            """
            {
                "first_name": "Donkey",
                "last_name": "Kong",
                "thumbnail_src": "some/url/somewhere"
            }
            """;

    public static final String GAME_DUMMY_RESPONSE =
            """
            {
                "id": "1",
                "title": "Mario",
                "description": "Platforming fun for all ages",
                "thumbnail_src": "some/url/somewhere",
                "tags": [
                    {
                        "id": "1",
                        "name": "Platforming",
                        "description": "Game play focused on jumping from one platform to another"
                    }
                    {
                        "id": "2",
                        "name": "Action",
                        "description": "Game play focused on fast reflexes and quick thinking"
                    }
                ],
                "rating": "98",
                "rating_categories": [
                    {
                        "id": "1",
                        "name": "Game Play",
                        "description": "The primary experience of the player (e.g. how they control their character, how they engage with the world)"
                    }
                ]
            }
            """;
    public static final String LIST_GAMES_DUMMY_RESPONSE =
            """
            [
                {
                    "id": "1",
                    "title": "Mario",
                    "description": "Platforming fun for all ages",
                    "thumbnail_src": "some/url/somewhere",
                    "tags": [
                        {
                            "id": "1",
                            "name": "Platforming",
                            "description": "Game play focused on jumping from one platform to another"
                        },
                        {
                            "id": "2",
                            "name": "Action",
                            "description": "Game play focused on fast reflexes and quick thinking"
                        }
                    ],
                    "rating": "75",
                    "rating_categories": [
                        {
                            "id": "1",
                            "name": "Game Play",
                            "Rating": "100"
                        },
                        {
                            "id": "1",
                            "name": "Story",
                            "Rating": "50"
                        }
                    ]
                },
                {
                    "id": "2",
                    "title": "Zelda",
                    "description": "Adventure through the lands of Hyrule",
                    "thumbnail_src": "some/url/somewhere",
                    "tags": [
                        {
                            "id": "2",
                            "name": "Action",
                            "description": "Game play focused on fast reflexes and quick thinking"
                        }
                    ],
                    "rating": "98",
                    "rating_categories": [
                        {
                            "id": "1",
                            "name": "Game Play",
                            "rating": "98"
                        }
                    ]
                }
            ]
            """;
}
