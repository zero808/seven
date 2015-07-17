; Implement an unless with an else condition using macros.
(defmacro unless-with-else [test succ-body fail-body]
  (list 'if (list 'not test) succ-body fail-body))

; Write a type using defrecord that Implements a protocol

(defprotocol Point
  (coordinates [p])
  (dotProduct [a b])
  (distanceBetween [a b]))

(defrecord MyPoint [x y z]
  Point
  (coordinates [this] [x y z])
  (dotProduct [a b] (reduce + (map * (coordinates a) (coordinates b))))
  (distanceBetween [a b] (Math/sqrt (reduce + (map (fn [x] (Math/pow x 2))
                                                   (map - (coordinates a)
                                                        (coordinates b)))))))

(def a (MyPoint. 1 2 3))
(def b (MyPoint. 4 5 6))
(distanceBetween a b)
(distanceBetween b a)
(dotProduct a b)
(dotProduct b a)

