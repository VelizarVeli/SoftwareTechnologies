const userController = require('./../controllers/user');
const homeController = require('./../controllers/home');
const articleController = require('./../controllers/article');

module.exports = (app) => {
    app.get('/', homeController.index);
        //register
    app.get('/user/register', userController.registerGet);
    app.post('/user/register', userController.registerPost);
        //login
    app.get('/user/login', userController.loginGet);
    app.post('/user/login', userController.loginPost);

    app.get('/user/logout', userController.logout);
        //article
        app.get('/article/create',articleController.createGet);
        app.post('/article/create', articleController.createPost);

        app.get('/article/details/:id',articleController.details);
};

