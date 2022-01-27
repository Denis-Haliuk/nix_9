insert into manufacturers values (1, current_timestamp(), current_timestamp(), 1, 'Emarge', 'FR', 'Royal Canin');
insert into manufacturers values (2, current_timestamp(), current_timestamp(), 1, 'Flenceburgh', 'GR', 'Trixie');
insert into manufacturers values (3, current_timestamp(), current_timestamp(), 1, 'Los Angeles', 'US', 'Pedigree');
insert into manufacturers values (4, current_timestamp(), current_timestamp(), 1, 'Cardiff', 'UK', 'Purina ONE');
insert into manufacturers values (5, current_timestamp(), current_timestamp(), 1, 'New York', 'US', 'Acana');

insert into categories values (1, current_timestamp(), current_timestamp(), 1, 'for cats');
insert into categories values (2, current_timestamp(), current_timestamp(), 1, 'for dogs');
insert into categories values (3, current_timestamp(), current_timestamp(), 1, 'toy');
insert into categories values (4, current_timestamp(), current_timestamp(), 1, 'clothing');
insert into categories values (5, current_timestamp(), current_timestamp(), 1, 'accessories');
insert into categories values (6, current_timestamp(), current_timestamp(), 1, 'food');


insert into items values (1, current_timestamp(), current_timestamp(), 1, 'Royal Canin Small Adult dry dog food is formulated to meet the unique nutritional needs of small breed adult dogs, as they actually require higher levels of calories per pound of body weight than large dogs.
L-carnitine helps metabolize fat to help your dog maintain a healthy weight.
Ideal levels of EPA and DHA support healthy skin and a beautiful, shiny coat.
Plus, enhanced palatability helps satisfy even the pickiest eaters.
Add a variety in texture with Royal Canin Adult Beauty wet dog food.
And when your dog reaches their later years, there''s Royal Canin Small
Adult 8+ and Small Aging 12+ to help keep them happy and healthy as they age.', 'https://s7d2.scene7.com/is/image/PetSmart/5173207?$CLEARjpg$',
                          'Royal Canin® Size Health Nutrition Small Adult Dog Food', 46.99, 555,
                          1);
insert into items values (2, current_timestamp(), current_timestamp(), 1, 'Our ACANA foods always goes beyond the 1st ingredient, thoughtfully crafting our recipes from start to finish.
Feed your little wildcat a diet packed with quality animal ingredients.
Crafted to provide everything your kitten needs for peak growth and development,
ACANA First Feast is brimming with 70%* quality animal ingredients like free-run chicken and whole herring,
delivered fresh or raw** in their most nourishing form. Artificial colors,
flavors or preservatives are never added in our kitchen.
The result is a protein-rich, nutritious, and delicious cat food to help them live a healthy, happy life.
*approximate and derived from the unprocessed state of the ingredients.',
                          'https://assets.petco.com/petco/image/upload/f_auto,q_auto/3156131-center-1',
                          'ACANA First Feast For Kittens Chicken and Fish Dry Cat Food, 4 lbs.', 17.09, 555,
                          5);

insert into items values (3, current_timestamp(), current_timestamp(), 1,
'Purina ONE Sensitive - Rich in Turkey & Rice is a complete dry cat food which has been formulated to specifically
address the needs of choosy cats and those which suffer from sensitive digestions or food intolerances.
Purina ONE Sensitive provides the right balance of nutrients for your sensitive cat and the innovative Bifensis
Dual Defense formula supports your cat’s natural defences while helping to keep your cat healthy both from the inside and the out.
Omega 6 fatty acids and a balanced portion of zinc help to keep your cat’s skin supple and fur shiny.
A mix of natural fibres make sure that swallowed hair is transported easily through the digestive system and this
helps to reduce hairball formation.
This tasty kibble also includes chicory, a natural ingredient which helps to reduce nasty litter box smells.',
'https://shop-cdn-m.mediazs.com/bilder/purina/one/indoor/turkey/whole/grains/dry/cat/food/0/800/195931_mhi_min_0.jpg',
'Purina ONE Sensitive Turkey & Rice Dry Cat Food', 5.29, 555,
4);

insert into items values (4, current_timestamp(), current_timestamp(), 1,
                          'Purina ONE Sterilcat Rich in Beef and Wheat contains essential nutrients which target the specific nutritional needs of sterilised and castrated cats.
Neutered cats can suffer from hormonal changes and this can impact n your cat’s metabolism.
This can lead to weight gain and urinary issues. Purina ONE Sterilcat promotes a healthy metabolism and urine pH values.
In doing so it helps your cat to maintain a healthy weight and lean, strong muscles.
Purina ONE Sterilcat dry cat food contains Bifensis Dual Defense, a unique formula which supports your cat’s natural
defences and helps to keep it healthy inside and out.',
                          'https://shop-cdn-m.mediazs.com/bilder/purina/one/sterilcat/beef/wheat/dry/cat/food/3/800/195933_mhi_3.jpg',
                          'Purina ONE Sterilcat Beef & Wheat Dry Cat Food', 5.29, 555,
                          4);

insert into items values (5, current_timestamp(), current_timestamp(), 1,
                          'This delicious wet dog food from Pedigree is a balanced complete food which has been
formulated especially to meet the nutritional needs of adult dogs. It is made will ingredients which dogs love,
as well as ingredients to keep them healthy. Pedigree Adult Classic does not contain artificial colours, aromas or taste enhancers.
Only carefully selected ingredients go into Pedigree dog food to keep your dog happy and healthy.
Pedigree – a delicious meal each time.',
                          'https://shop-cdn-m.mediazs.com/bilder/pedigree/adult/classic/x/g/8/800/55089_pedigreeherzleberpans_8.jpg',
                          'Pedigree Adult Classic 12 x 400g', 5.29, 555,
                          3);

insert into items values (6, current_timestamp(), current_timestamp(), 1,
                          'This lightly padded Quilted Dog Coat in a delightful red brings colour
and warmth to the colder months of the year!
The soft brown plush material inside is extremely soft and fluffy to help keep your dog warm and happy.
It is ideal for sensitive dogs with little undercoat, as well as older dogs or those that tend to live indoors,
helping to offer protection on cold days.',
                          'https://shop-cdn-m.mediazs.com/bilder/quilted/dog/coat/7/800/81645_pla_hundemantel_steppmuster_hund_fg_8618_start_7.jpg',
                          'Quilted Dog Coat', 15.29, 555,
                          2);

insert into items values (7, current_timestamp(), current_timestamp(), 1,
                          '
Trixie Junior Mini Dumbbell at a glance:
A dumbbell chew toy with small nubs suitable for puppies
Ideal for chewing, playing and keeping your puppy occupied
Made of flexible latex: soft and gently on teeth
Easy to grip: light and non-slip with nubs on surface
Noiseless fun: no squeaker, suitable for skittish and nervous puppies
Colour: mint with multi-coloured nubs
Material: Latex
Size: approx. 10cm (L) x 3.5cm diameter',
                          'https://shop-cdn-m.mediazs.com/bilder/trixie/junior/mini/dumbbell/0/800/184559_pla_trixie_junior_mini_hantel_10cm_hs_01_0.jpg',
                          'Trixie Junior Mini Dumbbell', 2.49, 555,
                          2);



insert into category_item values (1, 2);
insert into category_item values (6, 2);
insert into category_item values (2, 1);
insert into category_item values (6, 1);

insert into category_item values (1, 3);
insert into category_item values (6, 3);

insert into category_item values (1, 4);
insert into category_item values (6, 4);

insert into category_item values (2, 5);
insert into category_item values (6, 5);

insert into category_item values (2, 6);
insert into category_item values (4, 6);

insert into category_item values (2, 7);
insert into category_item values (3, 7);


