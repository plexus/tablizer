# Tablizer

Fetch a HTML page and print out any tables as org-mode style text tables.

# Installation

You need the Clojure command line tools installed, see [Getting Started](https://clojure.org/guides/getting_started).

After that, just clone this repo.

# Use

Run from the command line with a URL as argument.

```
./tablizer.clj https://en.wikipedia.org/wiki/2016_African_Championships_in_Athletics_%E2%80%93_Men%27s_800_metres

| Rank | Heat | Name                  | Nationality                       | Time    | Notes |
| 1    | 3    | Boaz Kiprugut         |  Kenya                            | 1:48.63 | Q     |
| 2    | 3    | Sampson Laari         |  Ghana                            | 1:48.80 | Q     |
| 3    | 4    | Jacob Rozani          |  South Africa                     | 1:49.91 | Q     |
| 4    | 3    | Kabelo Mohlosi        |  South Africa                     | 1:49.94 | Q     |
| 5    | 1    | Nijel Amos            |  Botswana                         | 1:50.19 | Q     |
| 6    | 4    | Bacha Morka           |  Ethiopia                         | 1:50.25 | Q     |
| 7    | 3    | Nyasha Mutsetse       |  Zimbabwe                         | 1:50.34 | q     |
| 8    | 1    | Albertino Mamba       |  Mozambique                       | 1:50.39 | Q     |
```

# LICENSE

Copyright &copy; Arne Brasseur 2017

Licensed under the Mozilla Public License 2.0, see LICENSE.txt
