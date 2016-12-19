(ns adventure.core
  (:require [clojure.core.match :refer [match]]
            [clojure.string :as str])
  (:gen-class))


(def the-map

;1. South Quad
 {
  :south-quad {:desc "You see a big tower and feel a crisp breeze hit your face. The next riddle pops up:
Riddle: What has a head, a tail, is brown, and has no legs?
north: A Horse, east: A Turtle, west: A Penny "
           :title "in the south quad"
           :dir {:north :dcl
                 :west  :arc
                 :east  :dcl
                 :south :crce
                }
           :contents {:item :Laptop}}







;2. Main Quad

  :main-quad {:desc "Several people walk by you, talking about how wasted they got the previous night. Another riddle pops up:
Riddle: I go in hard. I come out soft. You blow me hard. What am I?
north: A Banana, south: Gum, west: A bubble?, east: uhh...who made this game? "
           :title "in the main quad"
           :dir {:south :isr
                 :north :dcl
                 :west  :crce
                 :east  :dcl
                 }}
            :contents {:item :Notebook}

;3. Grainger

  :grainger {:desc "You take the elevator to the 4th floor. How do people study here?
Another riddle pops up out of nowhere:
Riddle: The more you take, the more you leave behind. What am I?
north: A Cloud, south: Footsteps, east: Money  "
           :title "at grainger"
           :dir {:south :main-quad
                 :north :dcl
                 :west  :dcl
                 :east  :dcl
                 }
           :contents {:item :LED-Strips}}

;4. DCL

  :dcl {:desc "You chose the wrong option. Go back home. (:home)"

           :dir {:south :dcl
                 }
           :contents {}}


;5. Beckman Institute

  :beckman {:desc "You arrive, relieved you have everything to complete your final project. You work on it for a few hours and finish your PacMan game. Better go now so you dont fail! Hurry to ECEB! (:west) "
           :title "at the Beckman Institute"
           :dir {:south :dcl
                 :north :dcl
                 :west  :eceb
                 :east  :dcl
                 }
           :contents {}}
;6. NCSA

  :ncsa {:desc "You swipe your card and enter the building. Do work or play on the arcade machine? There's a riddle on the arcade machine.
Riddle: What is it that no man ever yet did see, which never was, but always is to be?
north: Death, south: Life, east: Books, west: Tomorrow "
           :title "at the NCSA"
           :dir {:south :dcl
                 :west  :beckman
                 :north :dcl
                 :east :dcl
                 }
           :contents {:item :Quartus-II-Software/Hardware-Package}}
;7. ECEB

  :eceb {:desc "A lot of classmates and teachers you don't necessarily want to see look back at you as you enter the building. "
           :title "at the ECEB"
           :dir {:south :talbot
                 :east  :beckman
                 }
           :contents {:item :final-project}}
;8. Talbot Lab

  :talbot {:desc "You have to use the bathroom all of a sudden. You remember taking a class here once and enter the building. There's a riddle on the wall.
Riddle: What belongs yo your but others use it more than you do?
north: Your Name, south: Your Money, west: Your Life, east: Your Breath"
           :title "at Talbot Lab"
           :dir {:west  :dcl
                 :north :ncsa
                 :east  :dcl
                 :south :dcl
                 }
           :contents {:item :TTL-Chips}}


;9. Cravings

  :cravings {:desc "Apparently a riddle is placed in a plate of orange chicken. You're not surprised considering the place.
Riddle: Mary's father has 4 children; three are named Nana, Nene, and Nini. What is the 4th child's name?
north: Nana, south: Nene, east: Mary, west: Nini "
           :title "at Cravings"
           :dir {:south :dcl
                 :north :dcl
                 :east  :talbot
                 :west  :dcl
                 }
           :contents {:item :VGA-Cable}}

;10. Bookstore

  :bookstore {:desc "Your gen ed class teacher wanted the latest edition of 'Writing about Trees.'It cost $140 here so you just torrented it. An incoming email warns you of ariddle.
Riddle: What can travel the world while staying in a corner?
north: A Stamp, south: A Pilot, east: A Book "
           :title "at the Bookstore"
           :dir {:south :dcl
                 :north :cravings
                 :east  :dcl
                 }
           :contents {:item :Lab-Manual}}
;11. ARC

  :arc {:desc "You haven't worked out in a month and feel guilty about being here. The sign in person has a riddle for you:
Riddle: Poor people have it. Rich people need it. If you eat it you die. What is it?
north: Nothing, east: Money, west: Hydrochloric Acid "
           :title "at the ARC"
           :dir {:north :bookstore
                 :east  :dcl
                 :west  :crce
                }
           :contents {:item :Monitor}}


;12. Siebel

  :siebel {:desc "You chose the wrong option. Go home. (:home) "

           :dir {:north :dcl
                 }
           :contents {}}


;13. Home

  :home {:desc "You wake up to your roommate yelling about how his ink pen exploded in the washing machine. 'What an idiot,' you think to yourself. You look at the time and see that you only have a few hours to make your final project for ECE 385.
Making a PacMan game using SystemVerilog was a bad idea. You groan and put on some clothes. You look around and see that none of your things are there.
You pick up your phone to see that you have several missed calls and texts. You open a few and conclude that your friends wanted to play the world's cruelest prank on you.
At the most inopportune time, they scattered your school items and things your need to do ECE 385 final project around campus.
You get one last text from your dear friend Hugh Mungus: 'Solve the riddles and you'll find your stuff.'
'Here we go' you think to yourself.
Answer the following riddle using the given choices. If you choose the correct choice, an item will be there for you to obtain.
Riddle: 'What is big and yellow and comes in the morning, to brighten mom's day?
north: The Sun, south: A Banana, west: A Schoolbus\n"
           :title "at your house"
           :dir {:south :siebel
                 :north :siebel
                 :west  :grainger
                 }
           :contents {:item :FPGA}}


;14. ISR Dorms

  :isr {:desc "You go to grab a snack from the dorm. The cashier stops you and asks you a riddle.
Riddle: What number do you get when you multiply all of the numbers on a telephone's number pad?
north: 215614, south: 0, west: 999"
           :title "at ISR"
           :dir {:south :south-quad
                 :north :dcl
                 :west  :crce
                 }
           :contents {:item :Pencil}}


;15. CRCE

  :crce {:desc "You chose the wrong answer. Go back home. (:home)"

           :dir {
                 :north :crce
                }
           :contents {}}

 })



(def adventurer
  {:location :home
   :inventory #{:FPGA :Notebook}
   :tick 0
   :seen #{}})

(defn status [player]
  (let [location (player :location)]
   (when-not ((player :seen) location)
     (print (-> the-map location :desc)))
   (println (str "You are " (-> the-map location :title) ". "))

    (update-in player [:seen] #(conj % location))))


(defn to-keywords [commands]
  (mapv keyword (str/split commands #"[.,?! ]+")))

(defn go [dir player]
  (let [location (player :location)
        dest (->> the-map location :dir dir)]
    (if (nil? dest)
      (do (println "You can't do that.")
          player)
      (assoc-in   player [:location] dest))))

(defn gohome [dir player]
  (let [location (player :location)
        dest (->> the-map :home :dir dir)]
    (assoc-in player [:home] dest)))

(defn search [player]
  ; (let [item (get-in the-map [room :contents])]
    (println (:location :contents)player)
   player)
  ; (update-in player [:seen] #(conj % :contents))))



(defn giveup[player]
(do (println "You give up on your ECE 385 Final Project. Might as well drop out.")
player)
(java.lang.System/exit 0))




(defn item [player]
  (let[location (player :location)
       cont (->> the-map location :contents :item)
       invent (player :inventory)]
    (if (nil? cont) ; if there are no objects then
        (do (println "There are no objects in this position.")
          player)

       (update-in player [:inventory] #(conj % cont))
      )))



(defn backpack[player]
  (let [items (player :inventory)]

      (do (println (player :inventory)) player)
      ))


(defn help [player]
  (let [location (player :location)
        invent (player :inventory)]
    (if (and (contains? invent :Quartus-II-Software/Hardware-Package) (contains? invent :Lab-Manual) (contains? invent :Monitor)
             (contains? invent :Pencil) (contains? invent :Laptop) (contains? invent :LED-Strips) (contains? invent :VGA-Cable) (contains? invent :FPGA)
             (contains? invent :Notebook)
         (contains? invent :final-project)) ;meaning that all of the object have been gathered

        (do (println "There are 10 things you need before you can go to ECEB.")
        player))
      )player)


(defn commands [player]
  (do (println "The main commands: look, north, south, west, east, giveup, backpack, grab, status, reset, call, help, commands")
    )player)


(defn check [player]
  (let [location (player :location)
        invent (player :inventory)]
    (if (and (contains? invent :Quartus-II-Software/Hardware-Package) (contains? invent :Lab-Manual) (contains? invent :Monitor)
             (contains? invent :Pencil) (contains? invent :Laptop) (contains? invent :LED-Strips) (contains? invent :VGA-Cable) (contains? invent :FPGA)
             (contains? invent :Notebook) (identical? location :beckman))
      (do (println "You can now go to eceb. go west to make your project")player)
      (do (println "you cannot go to eceb yet, because you dont have all the object")player)
      ;;   (contains? invent :final-project)) ;meaning that all of the object have been gathered

))player)



(defn respond [player command]
  (match command
         [:look] (update-in player [:seen] #(disj % (-> player :location)))          ;1. look at current position
         (:or [:n] [:north] ) (go :north player)                                     ;2. go north
         [:south] (go :south player)                                                 ;3 go south
         [:west] (go :west player)                                                   ;4 go west
         [:east] (go :east player)                                                   ;5 go east
         [:giveup] (giveup player)                                                   ;6 give up and quit
         [:backpack] (backpack player)                                               ;7 look at inventory
         [:grab] (item player)                                                       ;8 grab item
         [:status] (search player)                                                   ;9 look at item in room
         [:reset] (gohome player)                                                    ;10 go home
         ;           player)
         [:call] (do (println "You call your friend Khory. He replies 'Hi bro how's it going?'
;You ask for help with the 225 lab due in an hour and he tells u
;he still hasn't done it. Looks like you're gonna take another 'L'tonight.")
            player)
         [:help] (help player)
         [:commands] (commands player)

         )
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (loop [local-map the-map
         local-player adventurer]
    (let [pl (status local-player)
          _  (println "What do you want to do? Make sure to answer the puzzle up there or type in 'look.' Make sure to grab the objects in each room ")
          command (read-line)]
      (recur local-map (respond pl (to-keywords command))))))
