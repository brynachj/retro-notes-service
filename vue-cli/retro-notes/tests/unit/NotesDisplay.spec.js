import { shallowMount, mount } from '@vue/test-utils';
import NotesDisplay from '@/components/NotesDisplay.vue';
import Note from '@/components/Note.vue';

describe('NotesDisplay', () => {
    it('creates the element with id notesList', () => {
        const wrapper = shallowMount(NotesDisplay)
        expect(wrapper.find('#notesList').exists()).toBe(true);
    })
    it('creates an ol element with no item in it', () => {
        const wrapper = shallowMount(NotesDisplay)
        expect(wrapper.find('#notesList ol').exists()).toBe(true);
        expect(wrapper.find('#notesList ol').isEmpty()).toBe(true);
    })
    it('displays one li element when passed one note', () => {
        const notes = [{
            "title":"title",
            "content":"content",
            "date":"2018-08-03T12:12:12+01:00",
            "id":'0'
        }];
        
        const wrapper = shallowMount(NotesDisplay, {
            propsData: {notes}
        });
        
        expect(wrapper.find('#notesList ol li').exists()).toBe(true);
        expect(wrapper.findAll('#notesList ol li')).toHaveLength(1);
    })

    it('displays one note element within the li', () => {
        const notes = [{
            "title":"title",
            "content":"content",
            "date":"2018-08-03T12:12:12+01:00",
            "id":'0'
        }];
        
        const wrapper = shallowMount(NotesDisplay, {
            propsData: {notes}
        });
        
        expect(wrapper.find('#notesList ol li').contains(Note)).toBe(true);
    })

    it('displays five li elements when passed five notes', () => {
        const notes = [
            {"title":"title1","content":"content1","date":"2018-08-03T12:12:12+01:00","id":'0'},
            {"title":"title2","content":"content2","date":"2018-08-03T12:12:12+01:00","id":'1'},
            {"title":"title3","content":"content3","date":"2018-08-03T12:12:12+01:00","id":'2'},
            {"title":"title4","content":"content4","date":"2018-08-03T12:12:12+01:00","id":'3'},
            {"title":"title5","content":"content5","date":"2018-08-03T12:12:12+01:00","id":'4'},
    ];
        
        const wrapper = shallowMount(NotesDisplay, {
            propsData: {notes}
        });
        
        expect(wrapper.findAll('#notesList ol li')).toHaveLength(5);

    })
    
    it('passes note data to note component', () => {
        const notes = [
            {"title":"title1","content":"content1","date":"2018-08-03T12:12:12+01:00","id":'0'}
        ];
        const wrapper = mount(NotesDisplay, {
            propsData : {notes}
        });

        expect(wrapper.find(Note).props().note).toEqual(notes[0]);
    })

})
