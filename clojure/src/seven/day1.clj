; exercise 1
; Implement a function called (big st n)that returns true if a string st
; is longer than n characters.
(defn big [st n]
  (and (string? st) (> (count st) n)))

; Write a function called (collection-type col) that returns :list,:map,
; or :vector based on the type of collection col.
(defn collection-type [col]
  ;I'm not seeing how the author expects me solve this with only the
  ;few functions introduced
  (cond (map? col) :map
        (list? col) :list
        (vector? col) :vector))
