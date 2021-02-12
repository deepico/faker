# Faker

Fork of https://github.com/paraseba/faker. The library adapted to use the [data.generators](https://github.com/clojure/data.generators)
instead of Clojure's built-in random generator functions. This way it is possible to provide a random seed and
generate a reproducible test dataset.

## Example

    (require '[faker.random])
    (require '[faker.name])

    (faker.random/with-rand-seed 42
      (faker.name/names 10))

    =>
    ("Amparo Beahan"
     "Drake O'Reilly"
     "Ivah Hoeger"
     "Jalyn Sawayn"
     "Camryn Kertzmann"
     "Gertrude Daugherty"
     "Eula Friesen"
     "Celia McGlynn"
     "Luella Bode"
     "Miss Alexandrea Hermiston")

## License

Source Copyright © 2010-2015 Sebastian Galkin. Distributed under the
Eclipse Public License, the same as Clojure uses. See the file LICENSE.
