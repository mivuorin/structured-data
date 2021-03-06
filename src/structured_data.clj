(ns structured-data
  (:use clojure.set))

(defn do-a-thing [x]
  (let [xx (+ x x)]
   (Math/pow xx xx)))

(defn spiff [v]
  (if (< (count v) 2)
    nil
    (+ (get v 0)
       (get v 2))))

(defn cutify [v]
  (conj v "<3"))

(defn spiff-destructuring [v]
  (let [[first second third] v]
        (+ first third)))

(defn point [x y]
  [x y])

(defn rectangle [bottom-left top-right]
  [bottom-left top-right])

(defn width [rectangle]
  (let [[[x1 y1][x2 y2]] rectangle]
  (- x2 x1)))

(defn height [[[x1 y1][x2 y2]]]
  (- y2 y1))

(defn square? [rectangle]
  (= (width rectangle) (height rectangle)))

(defn area [rectangle]
  (* (width rectangle) (height rectangle)))

(defn contains-point? [rectangle point]
  (let [ [[x1 y1][x2 y2]] rectangle
         [x y] point]
    (and (<= x1 x x2) (<= y1 y y2))))

(defn contains-rectangle? [outer inner]
  (let [ [p1 p2] inner]
    (and (contains-point? outer p1) (contains-point? outer p2))))

(defn title-length [book]
  (count (:title book)))

(defn author-count [book]
  (count (:authors book)))

(defn multiple-authors? [book]
  (> (author-count book) 1))

(defn add-author [book new-author]
  (assoc book :authors
    (conj (:authors book) new-author)))

(defn alive? [author]
  (not (contains? author :death-year)))

(defn element-lengths [collection]
  (map count collection))

(defn second-elements [collection]
  (let [second-element (fn [x] (get x 1))]
  (map second-element collection)))

(defn titles [books]
  (map :title books))

(defn monotonic? [a-seq]
  (if (apply <= a-seq)
    true
    (apply >= a-seq)))

(defn stars [n]
  (apply str (repeat n \*)))

(defn toggle [a-set elem]
  (if (contains? a-set elem)
    (disj a-set elem)
    (conj a-set elem)))

(defn contains-duplicates? [a-seq]
  (not= (count (set a-seq)) (count a-seq)))

(defn old-book->new-book [book]
  (assoc book :authors (set (:authors book))))

(defn has-author? [book author]
  (let [new-book (old-book->new-book book)]
  (contains? (:authors new-book) author)))

(defn authors [books]
  (let [book-authors (fn [book] (:authors book))
        new-books (map old-book->new-book books)]
  (apply union (map book-authors new-books))))

(defn all-author-names [books]
  (set (map :name (authors books))))

(defn author->string [author]
  (let [name (:name author)
        birth-year (:birth-year author)
        death-year (:death-year author) ]
    (cond (and birth-year death-year)
          (str name " (" birth-year " - " death-year ")")
          birth-year
          (str name " (" birth-year " - )")
          :else (str name))))

(defn authors->string [authors]
  (apply str (interpose ", " (map author->string authors))))

(defn book->string [book]
  (str (:title book) ", written by " (authors->string  (:authors book))))

(defn books->string [books]
  (let [many-books (if (> (count books) 1) "books" "book")]
  (if (empty? books)
    "No books."
    (str (count books) " " many-books ". "
         (apply str (map book->string books))
         "."))))

(defn books-by-author [author books]
  :-)

(defn author-by-name [name authors]
  :-)

(defn living-authors [authors]
  :-)

(defn has-a-living-author? [book]
  :-)

(defn books-by-living-authors [books]
  :-)

; %________%



