; Use refs to create a vector of accounts in memory. Create a debit and
; credit functions to change the balance of an account.

(def accounts (ref [0 0 0 0])) ; some accounts

(defn debit [account amount]
  (let [balance (@accounts account)]
    (when (>= balance amount)
      (dosync (alter accounts (fn [x y] (assoc x account (- balance y))) amount)))))

(defn credit [account amount]
  (let [balance (@accounts account)]
      (dosync (alter accounts (fn [x y] (assoc x account (+ balance y))) amount))))

;examples
(credit 1 20)
(debit 1 10)
